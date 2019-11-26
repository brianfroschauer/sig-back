package com.example.sigback.populator;

import com.example.sigback.entity.Product;
import com.example.sigback.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements CommandLineRunner, Ordered {

    private final ProductRepository repository;

    @Autowired
    public ProductLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new Product("ACEITE DE CANOLA", "Kilogramos"));
        repository.save(new Product("ZINC PREMIX", "Kilogramos"));
        repository.save(new Product("PREMIX NUTRILON 1 WINMIL POLVO", "Kilogramos"));
        repository.save(new Product("PREMIX NUTRILON 2 WINMIL POLVO", "Kilogramos"));
        repository.save(new Product("PREMIX NUTRILON 3 WINMIL POLVO", "Kilogramos"));
        repository.save(new Product("CLORURO DE SODIO", "Kilogramos"));
        repository.save(new Product("FOSFATO DIBASICO DE MAGNESIO", "Kilogramos"));
        repository.save(new Product("IRON PREMIX 23997", "Kilogramos"));
        repository.save(new Product("CARBONATO DE CALCIO FINE NAN 6661", "Kilogramos"));
        repository.save(new Product("ACEITE DE PALMA", "Kilogramos"));
        repository.save(new Product("MALTODEXTRIN 20 DE SODIUM", "Kilogramos"));
        repository.save(new Product("SOY LECITHIN POWDER METARIN", "Kilogramos"));
        repository.save(new Product("MALTODEXTRINA DE 15", "Kilogramos"));
        repository.save(new Product("OIL POWDER VEGETABLE NUTRIVIE", "Kilogramos"));
        repository.save(new Product("ACEITE ACIDO ARACHIDONICO", "Kilogramos"));
        repository.save(new Product("BASE NUTRILON SIN LACTOSA - FULDA", "Kilogramos"));
        repository.save(new Product("TRIGLICERIDOS DE CADENA MEDIA 60-40", "Kilogramos"));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
