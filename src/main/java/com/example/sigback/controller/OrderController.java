package com.example.sigback.controller;

import com.example.sigback.dto.OrderDTO;
import com.example.sigback.dto.ProductDTO;
import com.example.sigback.entity.Order;
import com.example.sigback.entity.Product;
import com.example.sigback.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final ModelMapper mapper;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findOne(@PathVariable Long id) {
        final Order order = service.findOne(id);
        return ResponseEntity.ok(mapper.map(order, OrderDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        final List<Order> orders = service.findAll();

        final List<OrderDTO> orderDTOs = orders.stream()
                .map(order -> mapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(orderDTOs);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody @Valid OrderDTO orderDTO) {
        final Order order = service.create(mapper.map(orderDTO, Order.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(order, OrderDTO.class));
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<OrderDTO> addProduct(@PathVariable Long id,
                                               @RequestBody @Valid ProductDTO productDTO) {

        final Order order = service.addProduct(id, mapper.map(productDTO, Product.class));
        return ResponseEntity.ok(mapper.map(order, OrderDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id,
                                           @RequestBody @Valid OrderDTO orderDTO) {
        final Order order = service.update(id, mapper.map(orderDTO, Order.class));
        return ResponseEntity.ok(mapper.map(order, OrderDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
