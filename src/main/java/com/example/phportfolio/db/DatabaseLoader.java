package com.example.phportfolio.db;

import com.example.phportfolio.domain.User;
import com.example.phportfolio.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final UserRepository repository;

    public DatabaseLoader(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new User("Frodo", "Baggins", "ring bearer"));
        this.repository.save(new User("Olga", "Star", "cool worker"));
        this.repository.save(new User("Maks", "Bad", "not good worker"));
        this.repository.save(new User("Vitaliy", "Good", "best worker"));
        this.repository.save(new User("Gregory", "Hopkins", "anonymous animbus"));
    }
}
