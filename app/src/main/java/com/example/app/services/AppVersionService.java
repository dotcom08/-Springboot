package com.example.app.services;


import com.example.app.dtos.UpdateCheckResponse;
import com.example.app.dtos.VersionRequest;
import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.repositories.AppVersionRepository;
import com.example.app.repositories.UserDeviceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AppVersionService {

    @Autowired
    private final AppVersionRepository appVersionRepository;

    @Autowired
    private final UserDeviceRepository userDeviceRepository;

//    public AppVersion createVersion(VersionRequest request) {
//
//    }
//
//    public Optional<AppVersion> getLatestVersion(Platform platform) {
//    }
//
//    public UpdateCheckResponse checkForUpdate(String userId, String currentVersion, Platform platform) {
//
//    }
//
//    private void updateUserDeviceLastSeen(String userId, Platform platform, String currentVersion) {
//
//    }
//
//    private boolean isNewerVersion(String latest, String current) {
//
//    }
//
//    public void logUpdate(String userId, String fromVersion, String toVersion, Platform platform, boolean success) {
//
//    }
//
//    public Object getUpdateStats() {
//
//    }
//
//    private Object getStatsForPlatform(Platform platform) {
//
//    }
}
