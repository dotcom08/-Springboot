package com.example.app.services;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.repositories.AppVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppVersionService implements IAppVersionService {

    @Autowired
    private final AppVersionRepository appVersionRepository;

    public AppVersionService(AppVersionRepository appVersionRepository) {
        this.appVersionRepository = appVersionRepository;
    }

    /**
     * Получить последнюю версию для платформы
     */
    @Override
    public Optional<AppVersion> getLatestVersion(Platform platform) {
        return appVersionRepository.findLatestByPlatform(platform);
    }

    @Override
    public Optional<AppVersion> getVersionById(Long id) {
        return appVersionRepository.findById(id);
    }

    /**
     * Создать новую версию приложения
     */
    @Override
    public AppVersion createVersion(AppVersion appVersion) {
        appVersion.setReleaseDate(LocalDateTime.now());

        return appVersionRepository.save(appVersion);
    }

    /**
     * Получить версии для платформы
     */
    @Override
    public List<AppVersion> getAllActiveVersionsByPlatform(Platform platform) {
        return appVersionRepository.findByPlatform(platform);
    }

    /**
     * Обновить информацию о версии
     */
    @Override
    public AppVersion updateVersion(Long id, AppVersion versionDetails ) {
        Optional<AppVersion> optionalAppVersion = appVersionRepository.findById(id);
        if(optionalAppVersion.isPresent()){
            AppVersion version = optionalAppVersion.get();
            version.setVersion(versionDetails.getVersion());
            version.setPlatform(versionDetails.getPlatform());
            version.setChangelog(versionDetails.getChangelog());
            version.setUpdateType(versionDetails.getUpdateType());
            version.setActive(versionDetails.isActive());
            return appVersionRepository.save(version);
        }
        return null;
    }

    /**
     * Удалить версию
     */
    @Override
    public boolean deleteVersion(Long id) {
        if (appVersionRepository.existsById(id)){
            appVersionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
