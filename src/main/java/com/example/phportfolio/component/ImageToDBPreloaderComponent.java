package com.example.phportfolio.component;

import com.example.phportfolio.domain.Image;
import com.example.phportfolio.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageToDBPreloaderComponent implements CommandLineRunner {
    private final ImageRepository repository;

    @Value("${value.imagepath}")
    private String imgPath;

    @Autowired
    public ImageToDBPreloaderComponent(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        try {
            Path path = Paths.get(imgPath);
            Files.createDirectories(path);

            System.out.println("IMG directory exist or is created!");
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

        this.repository.save(new Image("g.png", "Google Image", "Simple image description"));

    }
}
