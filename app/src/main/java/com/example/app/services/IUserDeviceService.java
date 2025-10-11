package com.example.app.services;

import com.example.app.models.Platform;
import com.example.app.models.UserDevice;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface IUserDeviceService {
    UserDevice createOrUpdateDevice(UserDevice device);
    List<UserDevice> getAllDevices();
    Optional<UserDevice> getDeviceById(Long id);
    boolean deleteDevice(Long id);
    List<UserDevice> getDevicesByUserId(String userId);
    UserDevice updateDevice(Long id, UserDevice deviceDetails);
}
