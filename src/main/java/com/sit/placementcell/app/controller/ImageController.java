package com.sit.placementcell.app.controller;


import com.sit.placementcell.app.entity.*;
import com.sit.placementcell.app.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sit/images")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @GetMapping("/all")
    public ResponseEntity<List<ImageEntity>> getAllImages() {
        return ResponseEntity.ok(imageService.getAllImages());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ImageEntity> findById(@PathVariable int id) {
        return ResponseEntity.ok(imageService.findImageById(id));
    }


    @GetMapping("img/{name}")
    public ResponseEntity<?> getImageByName(@PathVariable String name) {
        Optional<ImageEntity> imageOptional = imageService.findByUsername(name);

        if (imageOptional.isPresent()) {
            ImageEntity image = imageOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust content type based on your image type

            return new ResponseEntity<>(image.getImageData(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload-img")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
                                              @RequestParam("username") String username) {
        System.out.println("I am Here");
        try {
            ImageEntity image = new ImageEntity();
            image.setUsername(username);
            image.setImageData(file.getBytes());
            imageService.saveImage(image);
            return ResponseEntity.ok("Image uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

