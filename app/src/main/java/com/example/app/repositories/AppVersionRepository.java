package com.example.app.repositories;

import com.example.app.models.AppVersion;
import com.example.app.models.Platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppVersionRepository extends JpaRepository<AppVersion, Long> {
    // Найти все версии для определенной платформы
    List<AppVersion> findByPlatform(Platform platform);

    // Найти активные версии для платформы
    //List<AppVersion> findByPlatformAndIsActiveTrue(Platform platform);

    // Найти версию по номеру и платформе
    //Optional<AppVersion> findByVersionAndPlatform(String version, Platform platform);

    // Найти последнюю активную версию для платформы
    @Query("SELECT av FROM AppVersion av WHERE av.platform = :platform AND av.isActive = true ORDER BY av.releaseDate DESC LIMIT 1")
    Optional<AppVersion> findLatestByPlatform(@Param("platform") Platform platform);
}


