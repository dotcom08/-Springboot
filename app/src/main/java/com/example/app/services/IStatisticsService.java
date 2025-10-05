package com.example.app.services;

import com.example.app.dtos.UpdateStateDTO;

import java.util.Map;
import java.util.Objects;

public interface IStatisticsService {
    UpdateStateDTO getUpdateStatistics(String version);
    Map<String, Object> getGlobalStats();
}
