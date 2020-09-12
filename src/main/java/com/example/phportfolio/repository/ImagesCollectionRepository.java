package com.example.phportfolio.repository;

import com.example.phportfolio.domain.ImagesCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesCollectionRepository extends CrudRepository<ImagesCollection, Long> {
}
