package com.example.app.controllers;

import com.example.app.services.IAppVersionService;
import com.example.app.services.IUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/update")
public class UpdateController {
    @Autowired
    private IAppVersionService applicationService;
    @Autowired
    private IUserDeviceService userDeviceService;
}
