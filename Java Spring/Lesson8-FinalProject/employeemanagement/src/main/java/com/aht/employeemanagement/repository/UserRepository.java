package com.aht.employeemanagement.repository;

import com.aht.employeemanagement.model.admin.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByMail(String mail);

}
