package com.example.phportfolio.repository;

import com.example.phportfolio.domain.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends CrudRepository<Image, Long> {
    Optional<Image> findByPath(String path);
    List<Image> findAllByTitleContains(String title);
    List<Image> findAllByDescriptionContains(String description);
}
