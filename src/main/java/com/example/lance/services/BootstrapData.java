package com.example.lance.services;

import com.example.lance.dao.CustomerRepository;
import com.example.lance.dao.DivisionRepository;
import com.example.lance.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() < 5) {

            Customer customer1 = new Customer();
            customer1.setFirstName("Marcus");
            customer1.setLastName("Nerva");
            customer1.setAddress("123 Street");
            customer1.setPostal_code("12345");
            customer1.setPhone("(111)111-1111");
            customer1.setDivision_id(2L);
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setFirstName("Antoninus");
            customer2.setLastName("Pius");
            customer2.setAddress("123 Boulevard");
            customer2.setPostal_code("12345");
            customer2.setPhone("(222)222-2222");
            customer2.setDivision_id(2L);
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setFirstName("Marcus");
            customer3.setLastName("Traianus");
            customer3.setAddress("123 Avenue");
            customer3.setPostal_code("12345");
            customer3.setPhone("(333)333-3333");
            customer3.setDivision_id(2L);
            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setFirstName("Publius");
            customer4.setLastName("Hadrianus");
            customer4.setAddress("123 Drive");
            customer4.setPostal_code("12345");
            customer4.setPhone("(444)444-4444");
            customer4.setDivision_id(2L);
            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setFirstName("Marcus");
            customer5.setLastName("Aurelius");
            customer5.setAddress("123 Place");
            customer5.setPostal_code("12345");
            customer5.setPhone("(555)555-5555");
            customer5.setDivision_id(2L);
            customerRepository.save(customer5);


        }
    }
}
