package com.example.app.controllers;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;
import com.example.app.services.AppVersionService;
import com.example.app.services.IAppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/versions")
public class VersionController {
    @Autowired
    private IAppVersionService appVersionService;

    /**
     * Создать новую версию (POST /api/versions)
     */
    @PostMapping
    public ResponseEntity<AppVersion> createVersion(@RequestBody AppVersion appVersion){
        AppVersion savedAppVersion = appVersionService.createVersion(appVersion);
        return ResponseEntity.ok(savedAppVersion);
    }

    /**
     * Получить последнюю версию для платформы (GET /api/versions/latest?platform=android)
     */
    @GetMapping("/latest")
    public ResponseEntity<AppVersion> getLatestVersion(@RequestParam Platform platform){
        Optional<AppVersion> latestVersion = appVersionService.getLatestVersion(platform);
        return latestVersion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Получить версии для платформы
     */
    @GetMapping("/platform/{platform}")
    public ResponseEntity<List<AppVersion>> getVersionsByPlatform(@PathVariable Platform platform) {
        List<AppVersion> versions = appVersionService.getAllActiveVersionsByPlatform(platform);
        return ResponseEntity.ok(versions);
    }
    /**
     * Получить версию по ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<AppVersion> getVersionById(@PathVariable Long id){    
        Optional<AppVersion> version = appVersionService.getVersionById(id);
        return version.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        
    }

    /**
     * Обновить версию
     */
    @PutMapping("/{id}")
    public ResponseEntity<AppVersion> updateVersion(@PathVariable Long id, @RequestBody AppVersion versionDetails){

        AppVersion updatedversion = appVersionService.updateVersion(id, versionDetails);
        if(updatedversion != null) {
            return ResponseEntity.ok(updatedversion);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Удалить версию
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVersion(@PathVariable Long id) {
        boolean deleted = appVersionService.deleteVersion(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }



}
