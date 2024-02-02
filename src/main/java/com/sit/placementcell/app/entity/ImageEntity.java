package com.sit.placementcell.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Lob
    @Column(name = "image_data",columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @Column(name = "username")
    private String username;
}
