package com.aht.employeemanagement.repository;

import com.aht.employeemanagement.model.admin.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    public Role findByName(String name);

}
