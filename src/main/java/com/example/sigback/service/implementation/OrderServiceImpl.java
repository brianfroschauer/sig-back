package com.example.sigback.service.implementation;

import com.example.sigback.entity.Order;
import com.example.sigback.entity.Product;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.OrderRepository;
import com.example.sigback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order addProduct(Long id, Product product) {
        final Order order = findOne(id);
        order.addProduct(product);
        return repository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setPrice(order.getPrice());
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
