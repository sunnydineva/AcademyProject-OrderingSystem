package com.example.AacademyProject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Min(10) //Validations: валидира преди да се направи какъвто и да е call към сървиса
//    @Max(50)
    @Column(name = "customer_name",length = 50) //lenght-максимална дължина в базата
    private String customerName;

    @Column(name = "customer_last_name",length = 100)
    private String customerLastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email customerEmail;

    private String password;

    private Instant createdAt;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();


    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "customer_roles",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();
}
