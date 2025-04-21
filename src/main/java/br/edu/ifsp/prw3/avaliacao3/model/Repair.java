package br.edu.ifsp.prw3.avaliacao3.model;

import br.edu.ifsp.prw3.avaliacao3.dto.OutDateRepairDTO;
import br.edu.ifsp.prw3.avaliacao3.dto.RepairDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "repair")
@Entity(name = "Repair")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String entryDate;
    private String outDate;
    @Embedded
    private Vehicle vehicle;
    @Embedded
    private Mechanic mechanic;
    private boolean active;

    public Repair(RepairDTO dto){
        this.active = true;
        this.entryDate = dto.entryDate();
        this.outDate = dto.outDate();
        this.vehicle = new Vehicle(dto.vehicle());
        this.mechanic = new Mechanic(dto.mechanic());
    }

    public void updateInfo(OutDateRepairDTO dto){
        if(dto.outDate() != null) this.outDate = dto.outDate();
        if(dto.mechanic() != null) this.mechanic.updateInfo(dto.mechanic());
    }

    public void delete(){
        this.active = false;
    }
}
