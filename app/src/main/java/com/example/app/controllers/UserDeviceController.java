package com.example.app.controllers;

import com.example.app.models.UserDevice;
import com.example.app.services.UserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class UserDeviceController {

    @Autowired
    private final UserDeviceService userDeviceService;

    public UserDeviceController(UserDeviceService userDeviceService) {
        this.userDeviceService = userDeviceService;
    }

    /**
     * Создать или обновить устройство
     */
    @PostMapping
    public ResponseEntity<UserDevice> createOrUpdateDevice(@RequestBody UserDevice device) {
        UserDevice createdDevice = userDeviceService.createOrUpdateDevice(device);
        return ResponseEntity.ok(createdDevice);
    }

    /**
     * Получить все устройства
     */
    @GetMapping
    public ResponseEntity<List<UserDevice>> getAllDevices() {
        List<UserDevice> devices = userDeviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    /**
     * Получить устройство по ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDevice> getDeviceById(@PathVariable Long id) {
        Optional<UserDevice> device = userDeviceService.getDeviceById(id);
        return device.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Обновить устройство
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDevice> updateDevice(@PathVariable Long id, @RequestBody UserDevice deviceDetails) {
        UserDevice updatedDevice = userDeviceService.updateDevice(id, deviceDetails);
        if (updatedDevice != null) {
            return ResponseEntity.ok(updatedDevice);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Удалить устройство
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        boolean deleted = userDeviceService.deleteDevice(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Получить устройства пользователя
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserDevice>> getDevicesByUserId(@PathVariable String userId) {
        List<UserDevice> devices = userDeviceService.getDevicesByUserId(userId);
        return ResponseEntity.ok(devices);
    }
}
