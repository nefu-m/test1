package com.example.test1.repository;

import com.example.test1.entity.Address;
import com.example.test1.entity.User;
import com.example.test1.entity.UserAddress;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserAddressRepository {
    @PersistenceContext
    private EntityManager em;
    public User addUser() {
        User u1 = new User("MA");
        em.persist(u1);
        return u1;
    }
    public Address addAddress(){
        Address a1 = new Address("110");
        em.persist(a1);
        return a1;
    }

    public void showDetails() {


        var u2 = em.find(User.class, 1);
        var a2 = em.find(Address.class, 1);
        System.out.println(u2);
        System.out.println(a2);
        UserAddress ua = new UserAddress();
        ua.setUser(u2);
        ua.setAddress(a2);
        em.persist(ua);
        System.out.println(em.find(UserAddress.class, 1));
    }

    public void reshow(){
        User u = em.find(User.class, 1);
        System.out.println(u.getName());
        u.setName("MM");
        System.out.println(u.getName());
        em.flush();
        System.out.println(u.getName());
        em.refresh(u);
        System.out.println(u.getName());
        em.flush();
        System.out.println(u.getName());
    }
}
