package com.example.phportfolio.service;

import com.example.phportfolio.domain.Image;
import com.example.phportfolio.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ImageService {
    @Value("${value.imagepath}")
    private String imgPath;

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

    public String saveFromInputStream(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get(imgPath + File.separator + fileName);

        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            this.saveFromParameter(fileName, null, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/img/")
                .path(fileName)
                .toUriString();

        return fileDownloadUri;
    }

    public Resource getImageResource(String fileName) {
        Path path = Paths.get(imgPath + File.separator + fileName);
        if (new File(path.toUri()).exists()) {
            System.out.println(path.toAbsolutePath().toString());
        } else {
            return null;
        }

        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return resource;
    }
}
