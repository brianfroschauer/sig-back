package com.example.sigback.controller;

import com.example.sigback.dto.ClaimDTO;
import com.example.sigback.entity.Claim;
import com.example.sigback.service.ClaimService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService service;
    private final ModelMapper mapper;

    public ClaimController(ClaimService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDTO> findOne(@PathVariable Long id) {
        final Claim claim = service.findOne(id);
        return ResponseEntity.ok(mapper.map(claim, ClaimDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ClaimDTO>> findAll() {
        final List<Claim> claims = service.findAll();

        final List<ClaimDTO> claimDTOS = claims.stream()
                .map(claim -> mapper.map(claim, ClaimDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(claimDTOS);
    }

    @PostMapping
    public ResponseEntity<ClaimDTO> create(@RequestBody @Valid ClaimDTO claimDTO) {
        final Claim claim = service.create(mapper.map(claimDTO, Claim.class));

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(claim.getId()).toUri();

        return ResponseEntity.created(location).body(mapper.map(claim, ClaimDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
