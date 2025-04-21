package br.edu.ifsp.prw3.avaliacao3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VehicleDTO(
        @NotBlank
        String brand,

        @Pattern(regexp = "\\b\\d{4}\\b")
        @NotNull
        String yearVehicle,

        @NotBlank
        String model,

        String colorVehicle) {
}
