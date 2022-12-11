package com.application.internetbanking.controllers;

import com.application.internetbanking.models.Customer;
import com.application.internetbanking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/customer/{id}")
    public Customer updateCustomerDetails(@RequestBody Customer customer, @PathVariable("id") Long id){
        return customerService.updateCustomerById(customer, id);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return "Deleted Successfully";
    }
}
