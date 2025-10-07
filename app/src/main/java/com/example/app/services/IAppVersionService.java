package com.example.app.services;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;

import java.util.List;
import java.util.Optional;

public interface IAppVersionService {
    Optional<AppVersion> getLatestVersion(Platform platform);
    AppVersion createVersion(AppVersion application);
    List<AppVersion> getAllActiveVersions(Platform platform);
    Optional<AppVersion> checkForUpdate(Platform platform, String currentVersion);
    AppVersion updateVersionType(Long id, UpdateType updateType);

}
