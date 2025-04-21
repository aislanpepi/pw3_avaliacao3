package br.edu.ifsp.prw3.avaliacao3.dto;

import jakarta.validation.constraints.NotNull;

public record OutDateRepairDTO (
        @NotNull
        Long id,
        String outDate,
        MechanicDTO mechanic){
}
