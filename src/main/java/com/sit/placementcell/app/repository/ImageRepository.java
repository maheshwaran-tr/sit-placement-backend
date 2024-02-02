package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageEntity,Integer> {
    Optional<ImageEntity> findByUsername(String username);
}
