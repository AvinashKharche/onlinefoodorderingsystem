package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Customer;
import org.nyu.onlinefoodorderingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(long customerId) {
        Optional<Customer> optional = customerRepository.findById(customerId);
        if (optional.isPresent()) return optional.get();
        throw new NoSuchElementException();
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void addCustomers(List<Customer> customers) {
        customers.stream().forEach(c -> c.setCreatedDate(new Timestamp(System.currentTimeMillis())));
        customerRepository.saveAll(customers);
    }

    public void addCustomer(Customer customer) {
        customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        customerRepository.save(customer);
    }
}
