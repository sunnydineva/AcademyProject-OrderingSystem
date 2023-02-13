package com.example.AacademyProject.repository;

import com.example.AacademyProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    // можем да си пишем и свои методи "findBy +името на полето"
    // нямаме клас, който да го инстанцира и да му казва какво да прави
}
