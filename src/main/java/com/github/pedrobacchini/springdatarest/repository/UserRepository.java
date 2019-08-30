package com.github.pedrobacchini.springdatarest.repository;

import com.github.pedrobacchini.springdatarest.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
