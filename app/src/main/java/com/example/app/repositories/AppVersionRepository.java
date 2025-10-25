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

    Optional<AppVersion> findFirstByPlatformOrderByReleaseDateDesc(Platform platform);

    List<AppVersion> findByPlatformOrderByReleaseDateDesc(Platform platform);

    boolean existsByVersionAndPlatform(String version, Platform platform);

    @Query("SELECT av FROM AppVersion av WHERE av.platform = :platform AND av.version > :currentVersion ORDER BY av.releaseDate DESC")
    List<AppVersion> findNewerVersions(@Param("platform") Platform platform,
                                       @Param("currentVersion") String currentVersion);
}


