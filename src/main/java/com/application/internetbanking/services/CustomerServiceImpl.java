package com.application.internetbanking.services;

import com.application.internetbanking.exceptions.CustomerNotFoundException;
import com.application.internetbanking.models.Customer;
import com.application.internetbanking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomerById(Customer customer, Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with id %s", id)));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAnnualIncome(customer.getAnnualIncome());
        existingCustomer.setLocation(customer.getLocation());
        existingCustomer.setDob(customer.getDob());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
