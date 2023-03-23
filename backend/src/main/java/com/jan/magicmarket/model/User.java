package com.jan.magicmarket.model;

import com.jan.magicmarket.config.constants.Gender;
import com.jan.magicmarket.config.constants.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String emailAddress;

    @Column
    private String password;

    @Column
    private String IBAN;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private Boolean active;

    @JoinColumn(name = "cart_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Set<Address> addressList = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Order> orderList = new HashSet<>();
}
