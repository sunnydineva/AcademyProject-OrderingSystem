package com.example.AacademyProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email_address",length = 50)
    private String emailAddress;

    @OneToOne(mappedBy = "customerEmail")
    private Customer customer;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
