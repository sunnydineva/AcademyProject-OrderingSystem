package com.example.AcademyProjectS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String products;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference //тук да спира да върти менаджираната референция - stackoverflow error
    private Customer customer;
}
