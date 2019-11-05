package com.example.sigback.service.implementation;

import com.example.sigback.entity.OrderItem;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.OrderItemRepository;
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

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
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
}
