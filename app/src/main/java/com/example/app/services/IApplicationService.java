package com.example.app.services;

import com.example.app.models.Application;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IApplicationService {
    Optional<Application> getLatestVersion(Platform platform);
    Application createVersion(Application application);
    List<Application> getAllActiveVersions(Platform platform);
    Optional<Application> checkForUpdate(Platform platform, String currentVersion);
    Application updateVersionType(Long id, UpdateType updateType);

}
