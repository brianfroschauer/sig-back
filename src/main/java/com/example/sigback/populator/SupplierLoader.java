package com.example.sigback.populator;

import com.example.sigback.entity.Supplier;
import com.example.sigback.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class SupplierLoader implements CommandLineRunner, Ordered {

    private final SupplierRepository repository;

    @Autowired
    public SupplierLoader(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new Supplier("CARGIL NV", "34-16446991-0", "CARGIL NV"));
        repository.save(new Supplier("DSM NUTRITIONAL PRODUCTS MEXICO", "17-16416403-9", "DSM NUTRITIONAL PRODUCTS MEXICO"));
        repository.save(new Supplier("DSM PRODUCTOS NUTRICIONAIS LTDA", "32-36416728-2", "DSM PRODUCTOS NUTRICIONAIS LTDA"));
        repository.save(new Supplier("KIRSCH PHARMA GMBH", "23-37416887-4", "KIRSCH PHARMA GMBH"));
        repository.save(new Supplier("DANONE LTDA", "30-91416231-2", "DANONE LTDA"));
        repository.save(new Supplier("ROHSTOFF TRADING", "26-11416569-1", "ROHSTOFF TRADING"));
        repository.save(new Supplier("CARGILL PALM PRODUCTS SDN BHD.", "20-32964416-8", "CARGILL PALM PRODUCTS SDN BHD."));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
