package com.scaler.demo.jobs;

import com.scaler.demo.Model.Product;
import com.scaler.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Properties;

@Component
public class schedulerjob {

    private ProductRepository productRepository;

    public schedulerjob(ProductRepository productRepository) {
        productRepository = productRepository;
    }

   // @Scheduled(cron = "0 * * * * *")
    public void executeJob() {
        Optional<Product> p = Optional.ofNullable(productRepository.getProductById(1));
        if (p.isPresent()) {
            System.out.println(p.get().getTitle());

        }
    }
}
