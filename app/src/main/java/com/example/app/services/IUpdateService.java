package com.example.app.services;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;

import java.util.Optional;

public interface IUpdateService {
    Optional<AppVersion> checkForUpdate(Platform platform, String currentVersion);
    Optional<AppVersion> getLatestVersion(Platform platform);
    boolean isMandatoryUpdateRequired(Platform platform, String currentVersion);
    Optional<UpdateType> getUpdateType(Platform platform, String currentVersion);
}
