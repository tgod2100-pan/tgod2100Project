package com.tgod2100.life_insurance.controller;

import com.tgod2100.life_insurance.entity.Customer;
import com.tgod2100.life_insurance.service.CustomerService;
import com.tgod2100.life_insurance.dto.UpdateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Flux<Customer> getAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable Long id, @RequestBody UpdateCustomerRequest req) {
        return customerService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return customerService.deleteById(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAll() {
        return customerService.deleteAll();
    }

}
