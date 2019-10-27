package com.example.sigback.controller;

import com.example.sigback.dto.TruckDTO;
import com.example.sigback.entity.Truck;
import com.example.sigback.service.TruckService;
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
@RequestMapping("/trucks")
public class TruckController {

    private final TruckService service;
    private final ModelMapper mapper;

    @Autowired
    public TruckController(TruckService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruckDTO> findOne(@PathVariable Long id) {
        final Truck truck = service.findOne(id);
        return ResponseEntity.ok(mapper.map(truck, TruckDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<TruckDTO>> findAll() {
        final List<Truck> trucks = service.findAll();

        final List<TruckDTO> truckDTOs = trucks.stream()
                .map(truck -> mapper.map(truck, TruckDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(truckDTOs);
    }

    @PostMapping
    public ResponseEntity<TruckDTO> create(@RequestBody @Valid TruckDTO truckDTO) {
        final Truck truck = service.create(mapper.map(truckDTO, Truck.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(truck.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(truck, TruckDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TruckDTO> update(@PathVariable Long id,
                                           @RequestBody @Valid TruckDTO truckDTO) {
        final Truck truck = service.update(id, mapper.map(truckDTO, Truck.class));
        return ResponseEntity.ok(mapper.map(truck, TruckDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
