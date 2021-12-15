package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(long customerId);

    List<Customer> getAllCustomer();

    void addCustomers(List<Customer> customers);

    void addCustomer(Customer customer);
}
