package com.example.sigback.controller;

import com.example.sigback.dto.DriverDTO;
import com.example.sigback.entity.Driver;
import com.example.sigback.service.DriverService;
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
@CrossOrigin(origins = "https://sig-front.herokuapp.com")
@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService service;
    private final ModelMapper mapper;

    @Autowired
    public DriverController(DriverService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> findOne(@PathVariable Long id) {
        final Driver driver = service.findOne(id);
        return ResponseEntity.ok(mapper.map(driver, DriverDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<DriverDTO>> findAll() {
        final List<Driver> drivers = service.findAll();

        final List<DriverDTO> driverDTOs = drivers.stream()
                .map(driver -> mapper.map(driver, DriverDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(driverDTOs);
    }

    @PostMapping
    public ResponseEntity<DriverDTO> create(@RequestBody @Valid DriverDTO driverDTO) {
        final Driver driver = service.create(mapper.map(driverDTO, Driver.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(driver.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(driver, DriverDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverDTO> update(@PathVariable Long id,
                                            @RequestBody @Valid DriverDTO driverDTO) {
        final Driver driver = service.update(id, mapper.map(driverDTO, Driver.class));
        return ResponseEntity.ok(mapper.map(driver, DriverDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
