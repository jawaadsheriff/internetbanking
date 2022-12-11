package com.application.internetbanking.services;

import com.application.internetbanking.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer updateCustomerById(Customer customer, Long id);
    void deleteCustomerById(Long id);

}
