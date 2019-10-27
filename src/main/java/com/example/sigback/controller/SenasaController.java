package com.example.sigback.controller;

import com.example.sigback.dto.SenasaDTO;
import com.example.sigback.entity.Senasa;
import com.example.sigback.service.SenasaService;
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
@RequestMapping("/senasa")
public class SenasaController {

    private final SenasaService service;
    private final ModelMapper mapper;

    @Autowired
    public SenasaController(SenasaService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SenasaDTO> findOne(@PathVariable Long id) {
        final Senasa senasa = service.findOne(id);
        return ResponseEntity.ok(mapper.map(senasa, SenasaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<SenasaDTO>> findAll() {
        final List<Senasa> senasas = service.findAll();

        final List<SenasaDTO> senasaDTOs = senasas.stream()
                .map(senasa -> mapper.map(senasa, SenasaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(senasaDTOs);
    }

    @PostMapping
    public ResponseEntity<SenasaDTO> create(@RequestBody @Valid SenasaDTO senasaDTO) {
        final Senasa senasa = service.create(mapper.map(senasaDTO, Senasa.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(senasa.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(senasa, SenasaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SenasaDTO> update(@PathVariable Long id,
                                            @RequestBody @Valid SenasaDTO senasaDTO) {
        final Senasa senasa = service.update(id, mapper.map(senasaDTO, Senasa.class));
        return ResponseEntity.ok(mapper.map(senasa, SenasaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
