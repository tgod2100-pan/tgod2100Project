package com.tgod2100.life_insurance.repository;

import com.tgod2100.life_insurance.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}
