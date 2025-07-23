package com.tgod2100.life_insurance.service;

import com.tgod2100.life_insurance.dto.UpdateCustomerRequest;
import com.tgod2100.life_insurance.entity.Customer;
import com.tgod2100.life_insurance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Mono<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> create(Customer customer) {
        if (customer.getRegisteredDateTime() == null) {
            customer.setRegisteredDateTime(LocalDateTime.now());
        }
        return customerRepository.save(customer);
    }

    public Mono<Customer> update(Long id, UpdateCustomerRequest req) {
        return customerRepository.findById(id).flatMap(existing -> {
            existing.setName(req.getName());
            //existing.setIdNumber(req.getIdNumber());
            //existing.setBirthDate(req.getBirthDate());
            //existing.setGender(req.getGender());
            existing.setPhone(req.getPhone());
            existing.setEmail(req.getEmail());
            existing.setAddress(req.getAddress());
            //existing.setRegisteredDateTime(req.getRegisteredDateTime());
            return customerRepository.save(existing);
        });
    }

    public Mono<Void> deleteById(Long id) {
        return customerRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return customerRepository.deleteAll();
    }
}
