package br.edu.ifsp.prw3.avaliacao3.dto;

import br.edu.ifsp.prw3.avaliacao3.model.Repair;

public record DateRepairDTO(String entryDate,
                            String outDate,
                            String nameMechanic,
                            String brandVehicle,
                            String modelVehicle) {

    public DateRepairDTO(Repair repair){
        this(repair.getEntryDate(), repair.getOutDate(),
                repair.getMechanic().getNameMechanic(),
                repair.getVehicle().getBrand(), repair.getVehicle().getModel());
    }
}
