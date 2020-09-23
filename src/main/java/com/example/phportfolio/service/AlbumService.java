package com.example.phportfolio.service;

import com.example.phportfolio.domain.Image;
import com.example.phportfolio.domain.ImagesCollection;
import com.example.phportfolio.repository.ImagesCollectionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

@Service
public class AlbumService {
    private ImagesCollectionRepository albumRepository;

    public AlbumService(ImagesCollectionRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Optional<ImagesCollection> save(String title, String description) {
        ImagesCollection album = new ImagesCollection();

        if (title != null) album.setTitle(title);
        if (description != null) album.setDescription(description);
        album.setDate(LocalDate.now());
        album.setImageslist(new HashSet<>());

        ImagesCollection savedCollection = this.albumRepository.save(album);
        return Optional.of(savedCollection);
    }

}
