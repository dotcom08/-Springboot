package com.example.app.dtos;

import com.example.app.models.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStateDTO {
    private String Version;
    private Map<Platform, Integer> usersCount;
    private Double globalUpdateRate;
}
