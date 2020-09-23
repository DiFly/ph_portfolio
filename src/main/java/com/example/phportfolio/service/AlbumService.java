package com.example.phportfolio.service;

import com.example.phportfolio.domain.Album;
import com.example.phportfolio.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Optional<Album> save(String title, String description, LocalDate localDate) {
        Album album = new Album();

        if (title != null) album.setTitle(title);
        if (description != null) album.setDescription(description);
        if (localDate == null) {
            album.setDate(LocalDate.now());
        } else {
            album.setDate(localDate);
        }
        album.setImageslist(new HashSet<>());

        Album savedCollection = this.albumRepository.save(album);
        return Optional.of(savedCollection);
    }

}
