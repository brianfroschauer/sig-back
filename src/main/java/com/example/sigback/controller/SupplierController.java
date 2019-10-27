package com.example.sigback.controller;

import com.example.sigback.dto.SupplierDTO;
import com.example.sigback.entity.Supplier;
import com.example.sigback.service.SupplierService;
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
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService service;
    private final ModelMapper mapper;

    @Autowired
    public SupplierController(SupplierService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> findOne(@PathVariable Long id) {
        final Supplier supplier = service.findOne(id);
        return ResponseEntity.ok(mapper.map(supplier, SupplierDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> findAll() {
        final List<Supplier> suppliers = service.findAll();

        final List<SupplierDTO> supplierDTOs = suppliers.stream()
                .map(supplier -> mapper.map(supplier, SupplierDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(supplierDTOs);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> create(@RequestBody @Valid SupplierDTO supplierDTO) {
        final Supplier supplier = service.create(mapper.map(supplierDTO, Supplier.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(supplier.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(supplier, SupplierDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(@PathVariable Long id,
                                              @RequestBody @Valid SupplierDTO supplierDTO) {
        final Supplier supplier = service.update(id, mapper.map(supplierDTO, Supplier.class));
        return ResponseEntity.ok(mapper.map(supplier, SupplierDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
