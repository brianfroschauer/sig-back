package com.example.sigback.service.implementation;

import com.example.sigback.entity.*;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.ClaimRepository;
import com.example.sigback.repository.OrderItemRepository;
import com.example.sigback.service.ClaimService;
import com.example.sigback.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository repository;
    private final OrderService orderService;
    private final OrderItemRepository orderItemRepository;

    public ClaimServiceImpl(ClaimRepository repository,
                            OrderService orderService,
                            OrderItemRepository orderItemRepository) {
        this.repository = repository;
        this.orderService = orderService;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Claim findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Claim> findAll() {
        return repository.findAll();
    }

    @Override
    public Order create(Claim claim) {
        Order order = claim.getOrder();
        order.setState(OrderState.CONFLICT);
        order = orderService.save(order);
        claim.setOrder(order);
        repository.save(claim);
        return order;
    }

    @Override
    public void delete(Long id) {
        final Claim claim = findOne(id);
        repository.delete(claim);
    }

    @Override
    public void resolve(Claim claim) {
        final Set<OrderItem> items = claim.getOrder().getItems();
        for (OrderItem item: items) {
            item.setState(OrderItemState.INITIAL);
            orderItemRepository.save(item);
        }
        repository.delete(claim);
    }
}
