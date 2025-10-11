package com.example.app.repositories;


import com.example.app.models.Platform;
import com.example.app.models.UserDevice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {
    // Найти устройства по идентификатору пользователя
    List<UserDevice> findByUserId(String userId);

    // Найти устройства по платформе
    List<UserDevice> findByPlatform(Platform platform);

    // Найти устройства по версии приложения
    List<UserDevice> findByCurrentVersion(String currentVersion);

    // Найти устройство по userId и платформе
    Optional<UserDevice> findByUserIdAndPlatform(String userId, Platform platform);


}
