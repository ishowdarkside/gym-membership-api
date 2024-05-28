package com.ishowdarkside.gym_membership.repository;


import com.ishowdarkside.gym_membership.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    private EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }



    @Transactional
    public User createUser(User user){
        this.entityManager.persist(user);
        return  user;
    }




}
