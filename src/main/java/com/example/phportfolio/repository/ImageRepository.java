package com.example.phportfolio.repository;

import com.example.phportfolio.domain.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<Image, Long> {
    Optional<Image> findByPath(String path);
    Iterable<Image> findAllByTitleContains(String title);
    Iterable<Image> findAllByDescriptionContains(String description);
}
