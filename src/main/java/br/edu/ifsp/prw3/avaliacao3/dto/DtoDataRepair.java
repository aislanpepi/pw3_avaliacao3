package br.edu.ifsp.prw3.avaliacao3.dto;

import br.edu.ifsp.prw3.avaliacao3.model.Mechanic;
import br.edu.ifsp.prw3.avaliacao3.model.Repair;
import br.edu.ifsp.prw3.avaliacao3.model.Vehicle;

public record DtoDataRepair(Long id, String entryDate, String outDate, Mechanic mechanic, Vehicle vehicle) {

    public DtoDataRepair(Repair repair){
        this(repair.getId(), repair.getEntryDate(), repair.getOutDate(), repair.getMechanic(), repair.getVehicle());
    }
}
