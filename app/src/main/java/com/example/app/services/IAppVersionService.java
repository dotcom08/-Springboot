package com.example.app.services;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;

import java.util.List;
import java.util.Optional;

public interface IAppVersionService {
    Optional<AppVersion> getLatestVersion(Platform platform);
    Optional<AppVersion> getVersionById(Long id);
    AppVersion createVersion(AppVersion application);
    List<AppVersion> getAllActiveVersionsByPlatform(Platform platform);
    AppVersion updateVersion(Long id, AppVersion appVersion);
    boolean deleteVersion(Long id);

}
