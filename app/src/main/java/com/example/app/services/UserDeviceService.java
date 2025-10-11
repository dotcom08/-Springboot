package com.example.app.services;


import com.example.app.models.UserDevice;
import com.example.app.repositories.UserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserDeviceService implements IUserDeviceService{
    @Autowired
    private final UserDeviceRepository userDeviceRepository;

    public UserDeviceService(UserDeviceRepository userDeviceRepository){
        this.userDeviceRepository = userDeviceRepository;
    }


    /**
     * Создать или обновить информацию об устройстве
     */
    @Override
    public UserDevice createOrUpdateDevice(UserDevice device) {
        // Проверить, существует ли уже устройство для этого пользователя и платформы
        Optional<UserDevice> existingDevice = userDeviceRepository
                .findByUserIdAndPlatform(device.getUserId(), device.getPlatform());

        if (existingDevice.isPresent()) {
            // Обновить существующее устройство
            UserDevice updatedDevice = existingDevice.get();
            updatedDevice.setCurrentVersion(device.getCurrentVersion());
            updatedDevice.setLastSeen(LocalDateTime.now());
            return userDeviceRepository.save(updatedDevice);
        } else {
            // Создать новое устройство
            device.setLastSeen(LocalDateTime.now());
            return userDeviceRepository.save(device);
        }
    }

    /**
     * Получить все устройства
     */
    @Override
    public List<UserDevice> getAllDevices() {
        return userDeviceRepository.findAll();
    }

    /**
     * Получить устройство по ID
     */

    @Override
    public Optional<UserDevice> getDeviceById(Long id) {
        return userDeviceRepository.findById(id);
    }

    /**
     * Обновить информацию об устройстве
     */
    public UserDevice updateDevice(Long id, UserDevice deviceDetails) {
        Optional<UserDevice> optionalDevice = userDeviceRepository.findById(id);
        if (optionalDevice.isPresent()) {
            UserDevice device = optionalDevice.get();
            device.setUserId(deviceDetails.getUserId());
            device.setPlatform(deviceDetails.getPlatform());
            device.setCurrentVersion(deviceDetails.getCurrentVersion());
            device.setLastSeen(LocalDateTime.now());
            return userDeviceRepository.save(device);
        }
        return null;
    }

    /**
     * Удалить устройство
     */
    @Override
    public boolean deleteDevice(Long id) {
        if (userDeviceRepository.existsById(id)) {
            userDeviceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Получить устройства пользователя
     */
    @Override
    public List<UserDevice> getDevicesByUserId(String userId) {
        return userDeviceRepository.findByUserId(userId);
    }
}
