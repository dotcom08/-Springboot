package com.example.app.services;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;
import com.example.app.repositories.AppVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppVersionService implements IAppVersionService {

    @Autowired
    private final AppVersionRepository appVersionRepository;
    public AppVersionService(AppVersionRepository appVersionRepository){
        this.appVersionRepository = appVersionRepository;
    }
    @Override
    public Optional<AppVersion> getLatestVersion(Platform platform) {
        return Optional.empty();
    }

    @Override
    public AppVersion createVersion(AppVersion application) {
        return null;
    }

    @Override
    public List<AppVersion> getAllActiveVersions(Platform platform) {
        return List.of();
    }

    @Override
    public Optional<AppVersion> checkForUpdate(Platform platform, String currentVersion) {
        return Optional.empty();
    }

    @Override
    public AppVersion updateVersionType(Long id, UpdateType updateType) {
        return null;
    }
}
