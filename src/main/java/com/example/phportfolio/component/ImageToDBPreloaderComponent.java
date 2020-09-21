package com.example.phportfolio.component;

import com.example.phportfolio.domain.Image;
import com.example.phportfolio.domain.ImagesCollection;
import com.example.phportfolio.repository.ImageRepository;
import com.example.phportfolio.repository.ImagesCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;

@Component
@Transactional
public class ImageToDBPreloaderComponent implements CommandLineRunner {
    private final ImageRepository repository;
    private final ImagesCollectionRepository collectionRepository;

    @Value("${value.imagepath}")
    private String imgPath;

    @Autowired
    public ImageToDBPreloaderComponent(ImageRepository repository, ImagesCollectionRepository collectionRepository) {
        this.repository = repository;
        this.collectionRepository = collectionRepository;
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

        Image image1 = this.repository.save(new Image("g.png", "Google Image", "Simple image description"));
        this.repository.save(new Image("g.png", "Google Image 1", "Simple image description 1"));
        this.repository.save(new Image("g.png", "Google Image 2", "Simple image description 2"));

        ImagesCollection imgColl = this.collectionRepository.save(new ImagesCollection(
                "First Collection",
                "Collection description",
                LocalDate.now(),
                null, null, null
        ));

        Iterable<ImagesCollection> imagesCollectionsAll = this.collectionRepository.findAll();
        if (imagesCollectionsAll.iterator().hasNext()) {
            ImagesCollection next = imagesCollectionsAll.iterator().next();
            System.out.println(next);

            if (next.getImageslist() == null) next.setImageslist(new HashSet<Image>());
//            next.getImageslist().add(new Image("g.png", "Google Image 3", "Simple image description 3"));
            next.getImageslist().add(image1);
            ImagesCollection imagesCollection = this.collectionRepository.save(next);
            System.out.println(imagesCollection);
        }
    }
}
