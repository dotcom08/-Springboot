package com.example.app.services;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;
import com.example.app.repositories.AppVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateService implements IUpdateService{

    @Autowired
    private final AppVersionRepository appVersionRepository;

    public UpdateService(AppVersionRepository appVersionRepository) {
        this.appVersionRepository = appVersionRepository;
    }

    // Проверить наличие обновления для указанной платформы и версии
    @Override
    public Optional<AppVersion> checkForUpdate(Platform platform, String currentVersion) {
        return Optional.empty();
    }

    // Получить информацию о последней версии для платформы
    @Override
    public Optional<AppVersion> getLatestVersion(Platform platform) {
        return Optional.empty();
    }

    // Проверить, требуется ли обязательное обновление
    @Override
    public boolean isMandatoryUpdateRequired(Platform platform, String currentVersion) {
        return false;
    }

    // Получить тип обновления для текущей верси
    @Override
    public Optional<UpdateType> getUpdateType(Platform platform, String currentVersion) {
        return Optional.empty();
    }
}
