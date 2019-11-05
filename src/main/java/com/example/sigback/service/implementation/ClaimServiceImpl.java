package com.example.sigback.service.implementation;

import com.example.sigback.entity.Claim;
import com.example.sigback.entity.Order;
import com.example.sigback.entity.OrderState;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.ClaimRepository;
import com.example.sigback.service.ClaimService;
import com.example.sigback.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository repository;
    private final OrderService orderService;

    public ClaimServiceImpl(ClaimRepository repository,
                            OrderService orderService) {
        this.repository = repository;
        this.orderService = orderService;
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
        order = orderService.create(order);
        repository.save(claim);
        return order;
    }

    @Override
    public void delete(Long id) {
        final Claim claim = findOne(id);
        repository.delete(claim);
    }
}
