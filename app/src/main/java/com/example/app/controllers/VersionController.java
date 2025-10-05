package com.example.app.controllers;

import com.example.app.services.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/versions")
public class VersionController {
    @Autowired
    private IApplicationService applicationService;


}
