package br.edu.ifsp.prw3.avaliacao3.controller;

import br.edu.ifsp.prw3.avaliacao3.model.Vehicle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculos")
public class VehicleController {

    @PostMapping
    public void insert(@RequestBody Vehicle vehicleData){
        System.out.println(vehicleData);
    }
}
