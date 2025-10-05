package com.example.app.services;

import com.example.app.models.Application;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;
import com.example.app.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService implements IApplicationService{

    @Autowired
    private final ApplicationRepository applicationRepository;
    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }
    @Override
    public Optional<Application> getLatestVersion(Platform platform) {
        return Optional.empty();
    }

    @Override
    public Application createVersion(Application application) {
        return null;
    }

    @Override
    public List<Application> getAllActiveVersions(Platform platform) {
        return List.of();
    }

    @Override
    public Optional<Application> checkForUpdate(Platform platform, String currentVersion) {
        return Optional.empty();
    }

    @Override
    public Application updateVersionType(Long id, UpdateType updateType) {
        return null;
    }
}
