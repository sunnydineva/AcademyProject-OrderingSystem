package com.example.AcademyProjectS.runner;

import com.example.AcademyProjectS.entity.Customer;
import com.example.AcademyProjectS.entity.Email;
import com.example.AcademyProjectS.entity.Order;
import com.example.AcademyProjectS.repository.CustomerRepository;
import com.example.AcademyProjectS.repository.EmailRepository;
import com.example.AcademyProjectS.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        Customer customer = new Customer();
        customer.setCustomerName("Pesho");
        customer.setCustomerLastName("Peshev");

        Email email = new Email();
        email.setEmailAddress("pesho@mail.bg");
        Email savedEmail = emailRepository.save(email);

        customer.setCustomer_email(savedEmail);
        customerRepository.save(customer);

        Order order = new Order();
        order.setProducts("Potato, Banana, Lemon");
        Order savedOrder = orderRepository.save(order);
        Set<Order> orders = new HashSet<>();
        orders.add(savedOrder);
        customer.setOrders(orders);

        Customer savedCustomer = customerRepository.save(customer);//и без да го създаваме, пак ще се съхрани
        System.out.println(savedCustomer.getOrders());
    }
}
