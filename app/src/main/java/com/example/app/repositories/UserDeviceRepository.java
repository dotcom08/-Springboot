package com.example.app.repositories;


import com.example.app.models.Platform;
import com.example.app.models.UserDevice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {
    Optional<UserDevice> findByUserId(String userId);
    List<UserDevice> findByPlatformAndCurrentVersion(Platform platform, String version);
    List<UserDevice> findByPlatform(Platform platform);
    List<UserDevice> findByLastSeenAfter(LocalDateTime date);


}
