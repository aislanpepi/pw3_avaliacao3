package br.edu.ifsp.prw3.avaliacao3.model;


import br.edu.ifsp.prw3.avaliacao3.dto.VehicleDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String brand;
    private String yearVehicle;
    private String model;
    private String colorVehicle;

public Vehicle(VehicleDTO dto){
    this.brand = dto.brand();
    this.yearVehicle = dto.yearVehicle();
    this.model = dto.model();
    this.colorVehicle = dto.colorVehicle();
}
}
