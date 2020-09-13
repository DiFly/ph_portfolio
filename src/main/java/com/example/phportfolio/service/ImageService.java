package com.example.phportfolio.service;

import com.example.phportfolio.domain.Image;
import com.example.phportfolio.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ImageService {

    private ImageRepository repository;

    public ImageService(ImageRepository repository) {
        this.repository = repository;
    }

    public Optional<Image> save(Image image) {
        return Optional.of(this.repository.save(image));
    }

    public Optional<Image> saveFromParameter(String path, String title, String description, LocalDate date) {
        Image image = new Image();
        image.setPath(path);
        if (title != null) {
            image.setTitle(title);
        }
        if (description != null) {
            image.setDescription(description);
        }
        if (date != null) {
            image.setDate(date);
        } else {
            image.setDate(LocalDate.now());
        }

        return save(image);
    }

    public Optional<Image> findById(Long id) {
        return this.repository.findById(id);
    }

    Iterable<Image> findAllByTitleContains(String title){
        return this.repository.findAllByTitleContains(title);
    };

    Iterable<Image> findAllByDescriptionContains(String description) {
        return this.repository.findAllByDescriptionContains(description);
    }
}
