package com.aht.authenauthor.repository;

import com.aht.authenauthor.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}
