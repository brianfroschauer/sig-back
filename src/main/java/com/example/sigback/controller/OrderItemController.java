package com.example.sigback.controller;

import com.example.sigback.dto.OrderItemDTO;
import com.example.sigback.dto.SetRackDTO;
import com.example.sigback.entity.OrderItem;
import com.example.sigback.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: brianfroschauer
 * Date: 05/11/2019
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class OrderItemController {

    private final OrderItemService service;
    private final ModelMapper mapper;

    @Autowired
    public OrderItemController(OrderItemService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/valid")
    public ResponseEntity<List<OrderItemDTO>> findValid() {
        final List<OrderItem> items = service.findValid();

        final List<OrderItemDTO> itemDTOS = items.stream()
                .map(item -> mapper.map(item, OrderItemDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(itemDTOS);
    }

    @GetMapping("/stock")
    public ResponseEntity<List<OrderItemDTO>> findStock() {
        final List<OrderItem> items = service.findStock();

        final List<OrderItemDTO> itemDTOS = items.stream()
                .map(item -> mapper.map(item, OrderItemDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(itemDTOS);
    }

    @GetMapping("/quality")
    public ResponseEntity<List<OrderItemDTO>> findQuality() {
        final List<OrderItem> items = service.findQuality();

        final List<OrderItemDTO> itemDTOS = items.stream()
                .map(item -> mapper.map(item, OrderItemDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(itemDTOS);
    }

    @GetMapping("/non-conformity")
    public ResponseEntity<List<OrderItemDTO>> findNonConformity() {
        final List<OrderItem> items = service.findNonConformity();

        final List<OrderItemDTO> itemDTOS = items.stream()
                .map(item -> mapper.map(item, OrderItemDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(itemDTOS);
    }

    @PostMapping("/rack")
    public ResponseEntity<OrderItemDTO> setRack(@RequestBody SetRackDTO setRackDTO) {
        final OrderItem orderItem = service.setRack(setRackDTO.getOrderItem(), setRackDTO.getType());
        return ResponseEntity.ok(mapper.map(orderItem, OrderItemDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> update(@PathVariable Long id,
                                               @RequestBody @Valid OrderItemDTO orderItemDTO) {
        final OrderItem orderItem = service.update(id, mapper.map(orderItemDTO, OrderItem.class));
        return ResponseEntity.ok(mapper.map(orderItem, OrderItemDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
