package br.edu.ifsp.prw3.avaliacao3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MechanicDTO(
        @NotBlank
        String nameMechanic,

        int expYears
) {
}
