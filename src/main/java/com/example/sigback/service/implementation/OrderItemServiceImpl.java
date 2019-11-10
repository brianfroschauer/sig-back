package com.example.sigback.service.implementation;

import com.example.sigback.entity.OrderItem;
import com.example.sigback.entity.Rack;
import com.example.sigback.entity.RackType;
import com.example.sigback.entity.Stand;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.exception.NoMoreSpaceException;
import com.example.sigback.repository.OrderItemRepository;
import com.example.sigback.repository.RackRepository;
import com.example.sigback.repository.StandRepository;
import com.example.sigback.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 05/11/2019
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository repository;
    private RackRepository rackRepository;
    private StandRepository standRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository repository,
                                RackRepository rackRepository,
                                StandRepository standRepository) {
        this.repository = repository;
        this.rackRepository = rackRepository;
        this.standRepository = standRepository;
    }

    @Override
    public List<OrderItem> findValid() {
        return repository.findValid();
    }

    @Override
    public OrderItem update(Long id, OrderItem orderItem) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setState(orderItem.getState());
                    old.setProduct(orderItem.getProduct());
                    old.setQuantity(orderItem.getQuantity());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public OrderItem setRack(OrderItem orderItem, RackType type) {
        final Rack rack = rackRepository.findFirstByType(type);

        while (orderItem.getQuantity() > 0) {

            Stand stand = standRepository
                    .findFirstByRackIdAndIsFullIsFalse(rack.getId())
                    .orElseThrow(NoMoreSpaceException::new);

            int spaceAvailable = stand.getCapacity() - stand.getAmount();

            if (orderItem.getQuantity() >= spaceAvailable) {
                orderItem.setQuantity(orderItem.getQuantity() - spaceAvailable);
                stand.setFull(true);
                stand.setAmount(stand.getCapacity());

                final OrderItem subOrder = orderItem.clone2();
                subOrder.setQuantity(spaceAvailable);
                subOrder.setStand(stand);
                repository.save(subOrder);
            } else {
                stand.setAmount(stand.getAmount() + orderItem.getQuantity());
                final OrderItem subOrder = orderItem.clone2();
                subOrder.setStand(stand);
                orderItem.setQuantity(0);
                repository.save(subOrder);
            }
        }

        repository.deleteById(orderItem.getId());
        return orderItem;
    }

    @Override
    public List<OrderItem> findStock() {
        return repository.findAllByStateStock();
    }

    @Override
    public List<OrderItem> findQuality() {
        return repository.findAllByStateQuality();
    }
}
