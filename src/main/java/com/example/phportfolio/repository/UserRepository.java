package com.example.phportfolio.repository;

import com.example.phportfolio.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
