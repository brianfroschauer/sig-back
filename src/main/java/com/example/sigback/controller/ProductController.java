package com.example.sigback.controller;

import com.example.sigback.dto.ProductDTO;
import com.example.sigback.entity.Product;
import com.example.sigback.service.ProductService;
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
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ModelMapper mapper;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findOne(@PathVariable Long id) {
        final Product product = service.findOne(id);
        return ResponseEntity.ok(mapper.map(product, ProductDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        final List<Product> products = service.findAll();

        final List<ProductDTO> productDTOs = products.stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(productDTOs);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO productDTO) {
        final Product product = service.create(mapper.map(productDTO, Product.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(product, ProductDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,
                                           @RequestBody @Valid ProductDTO productDTO) {
        final Product product = service.update(id, mapper.map(productDTO, Product.class));
        return ResponseEntity.ok(mapper.map(product, ProductDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
