package com.example.hackathon2024.model.mapper;

import com.example.hackathon2024.dto.DeviceResponseDto;
import com.example.hackathon2024.model.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceResponseDto toDto(Device device);
}
