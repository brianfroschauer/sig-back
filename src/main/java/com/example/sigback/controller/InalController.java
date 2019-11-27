package com.example.sigback.controller;

import com.example.sigback.dto.InalDTO;
import com.example.sigback.entity.Inal;
import com.example.sigback.service.InalService;
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
@RequestMapping("/inal")
public class InalController {

    private final InalService service;
    private final ModelMapper mapper;

    @Autowired
    public InalController(InalService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InalDTO> findOne(@PathVariable Long id) {
        final Inal inal = service.findOne(id);
        return ResponseEntity.ok(mapper.map(inal, InalDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<InalDTO>> findAll() {
        final List<Inal> inals = service.findAll();

        final List<InalDTO> inalDTOs = inals.stream()
                .map(inal -> mapper.map(inal, InalDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(inalDTOs);
    }

    @PostMapping
    public ResponseEntity<InalDTO> create(@RequestBody @Valid InalDTO inalDTO) {
        final Inal inal = service.create(mapper.map(inalDTO, Inal.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(inal.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(inal, InalDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InalDTO> update(@PathVariable Long id,
                                          @RequestBody @Valid InalDTO inalDTO) {
        final Inal inal = service.update(id, mapper.map(inalDTO, Inal.class));
        return ResponseEntity.ok(mapper.map(inal, InalDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
