package com.citizenweb.tooling.honeyback.core.dao.repos;

import com.citizenweb.tooling.honeyback.core.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getUserById(long id);

}
