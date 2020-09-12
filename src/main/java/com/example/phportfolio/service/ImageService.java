package com.example.phportfolio.service;

import com.example.phportfolio.domain.Image;
import com.example.phportfolio.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    private ImageRepository repository;

    public ImageService(ImageRepository repository) {
        this.repository = repository;
    }

    public Optional<Image> findById(Long id) {
        return this.repository.findById(id);
    }

    Iterable<Image> findAllByTitleContains(String title){
        return this.repository.findAllByTitleContains(title);
    };
}
