package org.iteam.inventoryservice;

import org.iteam.inventoryservice.entities.Product;
import org.iteam.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository ){
        return
                args ->{

                    productRepository.save(new Product(null,"ordinateur",700,50));
                    productRepository.save(new Product(null,"imprimante",200,20));
                    productRepository.save(new Product(null,"smartphone",1700,7));

                    productRepository.findAll().forEach(product -> {
                        System.out.println(product.getName());
                    });

                };
    }
}
