package br.edu.ifsp.prw3.avaliacao3.model;

import br.edu.ifsp.prw3.avaliacao3.dto.MechanicDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {
    private String nameMechanic;
    private int expYears;

    public Mechanic(MechanicDTO dto){
        this.nameMechanic = dto.nameMechanic();
        this.expYears = dto.expYears();
    }
}
