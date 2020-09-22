package com.example.phportfolio.controller;

import com.example.phportfolio.domain.ImagesCollection;
import com.example.phportfolio.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AlbumCreatorController {
    private final AlbumService albumService;

    @Autowired
    public AlbumCreatorController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("admin/album")
    public ResponseEntity createAlbum(@RequestParam(name = "title") String title ) {
        Optional<ImagesCollection> savedAlbum = this.albumService.save(title);
        return ResponseEntity.ok(savedAlbum);
    }
}
