package com.demo.management.repositories;

import com.demo.management.entities.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
}
