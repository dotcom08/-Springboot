package com.example.app.services;

import com.example.app.models.Platform;
import com.example.app.models.UserDevice;
import com.example.app.repositories.UserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeviceService implements IUserDeviceService{
    @Autowired
    private final UserDeviceRepository userDeviceRepository;

    public UserDeviceService(UserDeviceRepository userDeviceRepository){
        this.userDeviceRepository = userDeviceRepository;
    }
    @Override
    public Optional<UserDevice> getUserDevice(String userId) {
        return Optional.empty();
    }

    @Override
    public void logUpdate(String userId, String newVersion) {

    }

    @Override
    public UserDevice registerOrUpdateDevice(String userId, Platform platform, String currentVersion) {
        return null;
    }
}
