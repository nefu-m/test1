package com.example.test1.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddressses;

    public User(String name) {
        this.name = name;
    }
}
