package com.example.app.repositories;


import com.example.app.models.Platform;
import com.example.app.models.UserDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {
    Optional<UserDevice> findByUserIdAndPlatform(String userId, Platform platform);

    List<UserDevice> findByPlatformAndCurrentVersion(Platform platform, String currentVersion);

    @Modifying
    @Query("UPDATE UserDevice ud SET ud.lastSeen = :lastSeen WHERE ud.userId = :userId AND ud.platform = :platform")
    void updateLastSeen(@Param("userId") String userId,
                        @Param("platform") Platform platform,
                        @Param("lastSeen") LocalDateTime lastSeen);

    @Query("SELECT ud.currentVersion, COUNT(ud) FROM UserDevice ud WHERE ud.platform = :platform GROUP BY ud.currentVersion")
    List<Object[]> getVersionStatsByPlatform(@Param("platform") Platform platform);


}
