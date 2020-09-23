package com.example.phportfolio.controller;

import com.example.phportfolio.domain.Album;
import com.example.phportfolio.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class AlbumCreatorController {
    private final AlbumService albumService;

    @Autowired
    public AlbumCreatorController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("admin/album")
    public ResponseEntity createAlbum(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "date") String date
            ) {
        LocalDate localDate;
        if (date == null | date.length() == 0) {
            localDate = LocalDate.now();
        } else {
            localDate = LocalDate.parse(date);
        }

        Optional<Album> savedAlbum = this.albumService.save(title, description, localDate);
        return ResponseEntity.ok(savedAlbum);
    }
}
