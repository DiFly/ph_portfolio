package com.example.phportfolio.controller;

import com.example.phportfolio.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageLoaderController {

    @Value("${value.imagepath}")
    private String imgPath;

    private final ImageService imgService;

    public ImageLoaderController(ImageService imgService) {
        this.imgService = imgService;
    }

    @PostMapping("/admin/upload")
    public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
        String fullImgPath = this.imgService.saveFromInputStream(file);
        return ResponseEntity.ok(fullImgPath);
    }

    @GetMapping("/img/{fileName:.+}")
    public ResponseEntity downloadFileFromLocal(@PathVariable String fileName) {
        System.out.println(fileName);

        Path path = Paths.get(imgPath + File.separator + fileName);

        if (new File(path.toUri()).exists()) {
            System.out.println(path.toAbsolutePath().toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //if we want to download
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
//                        resource.getFilename() + "\"")
//                .body(resource);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
