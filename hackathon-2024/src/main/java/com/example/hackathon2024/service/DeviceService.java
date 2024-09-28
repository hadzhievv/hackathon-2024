package com.example.hackathon2024.service;

import com.example.hackathon2024.dto.DeviceResponseDto;
import com.example.hackathon2024.model.mapper.DeviceMapper;
import com.example.hackathon2024.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;


    public DeviceResponseDto get(Long id) {
        return deviceMapper.toDto(deviceRepository.findById(id).orElseThrow());
    }
}
