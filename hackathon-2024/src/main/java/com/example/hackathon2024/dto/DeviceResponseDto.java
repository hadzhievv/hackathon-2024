package com.example.hackathon2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeviceResponseDto {

    @Schema(example = "a0f6e565-b3c4-5f9c-9364-381019e88906")
    private Long deviceId;

    @Schema(example = "SNPERFBURGAS02")
    private String productType;

    @Schema(example = "SNPERFBURGAS02")
    private String serialNumber;

    @Schema(example = "SNPERFBURGAS02")
    private String softwareVersion;

    @Schema(example = "SNPERFBURGAS02")
    private String hardwareVersion;

    @Schema(example = "SNPERFBURGAS02")
    private String comm_settings;

    @Schema(example = "BBraun France 12/06/2024")
    private String status;

}
