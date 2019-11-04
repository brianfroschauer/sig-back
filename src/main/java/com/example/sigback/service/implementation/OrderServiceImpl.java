package com.example.sigback.service.implementation;

import com.example.sigback.entity.Order;
import com.example.sigback.entity.OrderState;
import com.example.sigback.entity.Remito;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.exception.InvalidOrderException;
import com.example.sigback.repository.OrderRepository;
import com.example.sigback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> findAllInPlant() {
        return repository.findAllByState_Plant();
    }

    @Override
    public Order create(Order order) {
        order.setCreatedDate(LocalDate.now());
        order.setState(OrderState.COMING);
        return repository.save(order);
    }

    @Override
    public Order validate(Long id, Remito remito) {
        final Order order = findOne(id);
        if (!order.getItems().equals(remito.getItems()) ||
            !order.getSupplier().equals(remito.getSupplier()) ||
            !order.getCreatedDate().equals(remito.getCreatedDate())) {
            throw new InvalidOrderException();
        }
        order.setState(OrderState.PLANT);
        return repository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setPrice(order.getPrice());
                    old.setState(order.getState());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Order order = findOne(id);
        repository.delete(order);
    }
}
