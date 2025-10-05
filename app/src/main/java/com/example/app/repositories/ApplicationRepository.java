package com.example.app.repositories;

import com.example.app.models.Application;
import com.example.app.models.Platform;
import com.example.app.models.UpdateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Optional<Application> findByVersionAndPlatform(String version, Platform platform);
    List<Application> findByReleaseDateAfter(LocalDateTime date);
    List<Application> findByUpdateTypeAndIsActiveTrue(UpdateType updateType);

}
