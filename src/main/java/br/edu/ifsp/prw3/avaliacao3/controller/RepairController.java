package br.edu.ifsp.prw3.avaliacao3.controller;

import br.edu.ifsp.prw3.avaliacao3.dto.RepairDTO;
import br.edu.ifsp.prw3.avaliacao3.model.Repair;
import br.edu.ifsp.prw3.avaliacao3.persistence.RepairRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repairs")
public class RepairController {
    @Autowired
    private RepairRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody RepairDTO dto){
        repository.save(new Repair(dto));
    }
}
