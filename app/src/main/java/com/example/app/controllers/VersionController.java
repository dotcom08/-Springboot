package com.example.app.controllers;

import com.example.app.dtos.UpdateCheckResponse;
import com.example.app.dtos.UpdateLogRequest;
import com.example.app.models.AppVersion;
import com.example.app.models.Platform;
import com.example.app.services.AppVersionService;
import com.example.app.services.UserDeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/versions")
public class VersionController {
    @Autowired
    private final AppVersionService appVersionService;
    @Autowired
    private final UserDeviceService userDeviceService;

//    @PostMapping("/versions")
//    public ResponseEntity<AppVersion> createVersion(@Valid @RequestBody VersionRequest request) {
//
//    }
//
//    @GetMapping("/versions/latest")
//    public ResponseEntity<?> getLatestVersion(@RequestParam Platform platform) {
//
//    }
//
//    @GetMapping("/update/check")
//    public ResponseEntity<UpdateCheckResponse> checkForUpdate(
//            @RequestParam String userId,
//            @RequestParam String current,
//            @RequestParam Platform platform) {
//
//    }
//
//    @PostMapping("/update/log")
//    public ResponseEntity<?> logUpdate(@Valid @RequestBody UpdateLogRequest request) {
//
//    }
//
//    @GetMapping("/stats/updates")
//    public ResponseEntity<?> getUpdateStats() {
//
//    }



}
