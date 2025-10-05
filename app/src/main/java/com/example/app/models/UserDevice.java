package com.example.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_devices")
public class UserDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_id")
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Platform platform;

    @Column(nullable = false, name = "current_version")
    private String currentVersion;
    @Column(nullable = false, name = "last_seen")
    private LocalDateTime lastSeen;

    public UserDevice(String userId, Platform platform, String currentVersion){
        this.userId = userId;
        this.platform = platform;
        this.currentVersion = currentVersion;
        this.lastSeen = LocalDateTime.now();
    }

}
