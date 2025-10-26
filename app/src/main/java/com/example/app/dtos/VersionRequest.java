package com.example.app.dtos;

import com.example.app.models.Platform;
import com.example.app.models.UpdateType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VersionRequest {
    @NotNull
    private String version;
    @NotNull
    private Platform platform;
    private String changeLog;
    private UpdateType updateType = UpdateType.OPTIONAL;

}
