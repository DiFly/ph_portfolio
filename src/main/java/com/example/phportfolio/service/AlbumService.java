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

    public Optional<ImagesCollection> save(String title) {
        ImagesCollection imgCollection = new ImagesCollection(title, null, LocalDate.now(), null, null, new HashSet<Image>());
        ImagesCollection savedCollection = this.albumRepository.save(imgCollection);
        return Optional.of(savedCollection);
    }

}
