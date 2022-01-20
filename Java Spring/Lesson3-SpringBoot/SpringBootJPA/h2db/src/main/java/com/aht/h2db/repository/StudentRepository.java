package com.aht.h2db.repository;

import org.springframework.data.repository.CrudRepository;

import com.aht.h2db.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
