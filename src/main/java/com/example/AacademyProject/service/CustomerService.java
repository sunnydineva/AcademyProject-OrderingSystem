package com.example.AacademyProject.service;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.exceptions.UserNotFoundException;
import com.example.AacademyProject.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data //дано не се прецакаме
@Service

public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id)throws UserNotFoundException{
        Optional<Customer> customer;
        customer = this.customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        } else {
            throw new UserNotFoundException(String.format("User with %s id not found", id));
        }
    }

    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }
}
