package com.example.app.services;

import com.example.app.dtos.UpdateStateDTO;
import com.example.app.repositories.AppVersionRepository;
import com.example.app.repositories.UserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticsService implements IStatisticsService{
    @Autowired
    private UserDeviceRepository userDeviceRepository;
    @Autowired
    private AppVersionRepository appVersionRepository;

    @Override
    public UpdateStateDTO getUpdateStatistics(String version) {
        return null;
    }

    @Override
    public Map<String, Object> getGlobalStats() {
        return Map.of();
    }
}
