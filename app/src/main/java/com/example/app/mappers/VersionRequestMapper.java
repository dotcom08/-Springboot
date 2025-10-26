package com.example.app.mappers;

import com.example.app.dtos.VersionRequest;
import com.example.app.models.AppVersion;

public class VersionRequestMapper {

    public static VersionRequest toDto(AppVersion appVersion){
        if(appVersion == null){
            return null;
        }
        return VersionRequest.builder()
                .version(appVersion.getVersion())
                .platform(appVersion.getPlatform())
                .changeLog(appVersion.getChangelog())
                .updateType(appVersion.getUpdateType())
                .build();
    }

    public static AppVersion toEntity(VersionRequest versionRequest){
        if(versionRequest == null){
            return null;
        }
        AppVersion appVersion = new AppVersion();
        appVersion.setVersion(versionRequest.getVersion());
        appVersion.setPlatform(versionRequest.getPlatform());
        appVersion.setChangelog(versionRequest.getChangeLog());
        appVersion.setUpdateType(versionRequest.getUpdateType());

        return appVersion;

    }
}


