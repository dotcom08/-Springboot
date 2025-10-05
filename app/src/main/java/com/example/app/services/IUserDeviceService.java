package com.example.app.services;

import com.example.app.models.Platform;
import com.example.app.models.UserDevice;

import java.util.Optional;

public interface IUserDeviceService {
    Optional<UserDevice> getUserDevice(String userId);
    void logUpdate(String userId, String newVersion);
    UserDevice registerOrUpdateDevice(String userId, Platform platform, String currentVersion);
}
