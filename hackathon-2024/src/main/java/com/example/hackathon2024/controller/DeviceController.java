package com.example.hackathon2024.controller;

import com.example.hackathon2024.dto.DeviceResponseDto;
import com.example.hackathon2024.service.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.hackathon2024.configuration.WebPath.API_VERSION_1;
import static com.example.hackathon2024.configuration.WebPath.PATH_DEVICE;

@RestController
@RequestMapping(value = API_VERSION_1)
@RequiredArgsConstructor
@Tag(name = "Test Operations", description = "Operations related to the testing of the service")
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping(PATH_DEVICE)
    @Operation(summary = "Retrieves a test message", responses = @ApiResponse(responseCode = "200"))
    public DeviceResponseDto get(@PathVariable Long id) {
        return deviceService.get(id);
    }
}
