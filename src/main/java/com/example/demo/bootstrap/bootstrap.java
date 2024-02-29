package com.example.demo.bootstrap;


import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public bootstrap(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 1) {
            Division D = divisionRepository.findById(5L).orElse(null);

            Customer momo = new Customer("Momo", "Mochi", "023 Lazy Lane", "12345", "1234567890", D);
            Customer binx = new Customer("Binx", "Bonks", "023 Lazy Lane", "12345", "1234567890", D);
            Customer elli = new Customer("Elli", "Belli", "023 Lazy Lane", "12345", "1234567890", D);
            Customer tsuki = new Customer("Tsuki", "Duki", "023 Lazy Lane", "12345", "1234567890", D);
            Customer kohaku = new Customer("Kohaku", "Waku", "023 Lazy Lane", "12345", "1234567890", D);

            customerRepository.save(momo);
            customerRepository.save(binx);
            customerRepository.save(elli);
            customerRepository.save(tsuki);
            customerRepository.save(kohaku);
        }


    }
}
