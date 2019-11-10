package com.example.sigback.populator;

import com.example.sigback.entity.Rack;
import com.example.sigback.entity.RackType;
import com.example.sigback.entity.Stand;
import com.example.sigback.repository.StandRepository;
import com.example.sigback.service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class RackLoader implements CommandLineRunner, Ordered {

    private final RackService service;
    private final StandRepository repository;

    @Autowired
    public RackLoader(RackService service, StandRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Rack stock = new Rack(1);
        stock.setType(RackType.STOCK);
        stock = service.create(stock);

        createStands(stock);

        Rack quality = new Rack(2);
        quality.setType(RackType.QUALITY);
        quality = service.create(quality);

        createStands(quality);

        Rack nonConformity = new Rack(3);
        nonConformity.setType(RackType.NONCONFORMITY);
        nonConformity = service.create(nonConformity);

        createStands(nonConformity);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private void createStands( Rack rack) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    final Stand stand = new Stand(x, y, z, 10, rack);
                    repository.save(stand);
                }
            }
        }
    }
}
