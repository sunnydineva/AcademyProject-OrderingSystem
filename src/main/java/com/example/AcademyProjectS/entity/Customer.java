package com.example.AcademyProjectS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name = "customer_name", length = 50)
    private String customerName;

    @Column (name = "customer_last_name", length = 100)
    private String customerLastName;

    @OneToOne
    @JoinColumn(name = "email_id") // таблицата имайл ще създаде юзър ид, държащо ид на юзър
    private Email customer_email;

    @OneToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name = "customer_id")

    @JsonManagedReference //това е менажирана референция-stackoverflow error. Може и @JsonIgnore
    private Set<Order> orders = new HashSet<>();
}