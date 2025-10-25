package com.example.app.dtos;

import com.example.app.models.UpdateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCheckResponse {

    private boolean updateAvailable;
    private String latestVersion;
    private String currentVersion;
    private UpdateType updateType;
    private String changeLog;
    private boolean mandatoryUpdate = updateType == UpdateType.MANDATORY;

}
