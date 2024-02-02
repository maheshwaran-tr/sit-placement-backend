package com.sit.placementcell.app.service;


import com.sit.placementcell.app.entity.ImageEntity;
import com.sit.placementcell.app.repository.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }

    public ImageEntity findImageById(int id){
        return imageRepository.findById(id).orElse(null);
    }

    @Transactional
    public void saveImage(ImageEntity image) {
        imageRepository.save(image);
    }

    @Transactional
    public void deleteImage(int id){
        imageRepository.deleteById(id);
    }

    public Optional<ImageEntity> findByUsername(String username){
        return imageRepository.findByUsername(username);
    }



}
