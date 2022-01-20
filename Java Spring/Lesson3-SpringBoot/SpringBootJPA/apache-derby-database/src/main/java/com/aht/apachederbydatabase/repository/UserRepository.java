package com.aht.apachederbydatabase.repository;

import org.springframework.data.repository.CrudRepository;

import com.aht.apachederbydatabase.model.UserRecord;

public interface UserRepository extends CrudRepository<UserRecord, Long>  {

}
