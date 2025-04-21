package br.edu.ifsp.prw3.avaliacao3.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RepairDTO(
        @NotBlank
        @Pattern(regexp = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b", message = "Not valid")
        String entryDate,

        @NotBlank
        @Pattern(regexp = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b", message = "Not valid")
        String outDate,


        @Valid
        @NotNull
        VehicleDTO vehicle,

        @Valid
        @NotNull
        MechanicDTO mechanic
) {
}
