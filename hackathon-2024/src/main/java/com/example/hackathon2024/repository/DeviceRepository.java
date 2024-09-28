package com.example.hackathon2024.repository;

import com.example.hackathon2024.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
