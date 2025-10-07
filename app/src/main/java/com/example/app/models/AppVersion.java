package com.example.app.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_versions")
public class AppVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String version;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Platform platform;

    @Column(nullable = false, name = "release_date")
    private LocalDateTime releaseDate;

    @Column(columnDefinition = "TEXT")
    private String changelog;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "update_type")
    private UpdateType updateType;

    @Column(nullable = false)
    private boolean isActive = true;


}
