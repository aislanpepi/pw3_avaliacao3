package br.edu.ifsp.prw3.avaliacao3.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO (
    @NotBlank
    String login,

    @NotBlank
    String password){
}
