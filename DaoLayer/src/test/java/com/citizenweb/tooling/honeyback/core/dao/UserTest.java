package com.citizenweb.tooling.honeyback.core.dao;

import com.citizenweb.tooling.honeyback.core.dao.config.PersistenceJpaConfig;
import com.citizenweb.tooling.honeyback.core.dao.repos.UserRepoImpl;
import com.citizenweb.tooling.honeyback.core.domain.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringJUnitConfig(PersistenceJpaConfig.class)
public class UserTest {

    @Autowired
    UserRepoImpl userRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void getUser() {

        //Assertions.assertNotNull(userRepository);
        User user = userRepository.getUserById(1L);
        //Assertions.assertNotNull(em);

    }

}
