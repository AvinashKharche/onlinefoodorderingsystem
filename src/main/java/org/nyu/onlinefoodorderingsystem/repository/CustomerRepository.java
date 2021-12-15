package org.nyu.onlinefoodorderingsystem.repository;

import org.nyu.onlinefoodorderingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}