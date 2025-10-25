package com.example.app.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateLogRequest {
    @NotNull
    private String userId;

    @NotNull
    private String fromVersion;

    @NotNull
    private String toVersion;

    @NotNull
    private String platform;

    private boolean success;
    private String errorMessage;
}
