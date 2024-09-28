package com.example.hackathon2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Device implements Serializable {

    private static final long serialVersionUID = 5689726880323103044L;

    @Id
    private Long deviceId;
    private String productType;
    private String serialNumber;
    private String softwareVersion;
    private String hardwareVersion;
    private String comm_settings;
    private String status;
    protected LocalDateTime createdAt;
}
