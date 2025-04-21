package br.edu.ifsp.prw3.avaliacao3.controller;

import br.edu.ifsp.prw3.avaliacao3.dto.DateRepairDTO;
import br.edu.ifsp.prw3.avaliacao3.dto.RepairDTO;
import br.edu.ifsp.prw3.avaliacao3.model.Repair;
import br.edu.ifsp.prw3.avaliacao3.persistence.RepairRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repairs")
public class RepairController {
    @Autowired
    private RepairRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid RepairDTO dto){
        repository.save(new Repair(dto));
    }

    @GetMapping
    public Page<Repair> list(Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("daterepair")
    public List<DateRepairDTO> listDateRepair(){
        return repository.findAll().stream().map(DateRepairDTO::new).toList();
    }
}
