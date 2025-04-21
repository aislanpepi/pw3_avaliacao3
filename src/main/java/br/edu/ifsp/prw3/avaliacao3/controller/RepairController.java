package br.edu.ifsp.prw3.avaliacao3.controller;

import br.edu.ifsp.prw3.avaliacao3.dto.DateRepairDTO;
import br.edu.ifsp.prw3.avaliacao3.dto.DtoDataRepair;
import br.edu.ifsp.prw3.avaliacao3.dto.OutDateRepairDTO;
import br.edu.ifsp.prw3.avaliacao3.dto.RepairDTO;
import br.edu.ifsp.prw3.avaliacao3.model.Repair;
import br.edu.ifsp.prw3.avaliacao3.persistence.RepairRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("repairs")
public class RepairController {
    @Autowired
    private RepairRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid RepairDTO dto, UriComponentsBuilder uriBuilder){
        var repair = new Repair(dto);

        repository.save(repair);

        var uri = uriBuilder.path("/repairs/{id}").buildAndExpand(repair.getId()).toUri();

        return ResponseEntity.created(uri).body(new DtoDataRepair(repair));
    }

    @GetMapping
    public ResponseEntity list(Pageable pageable){
        var page = repository.findAllByActiveTrue(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRepairById(@PathVariable Long id) {
        Optional<Repair> optionalRep = repository.findById(id);
        if (optionalRep.isPresent()) {
            Repair repair = optionalRep.get();
            return ResponseEntity.ok(new DtoDataRepair(repair));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("daterepair")
    public ResponseEntity listDateRepair(){
        var list = repository.findAllByActiveTrue().stream().map(DateRepairDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid OutDateRepairDTO dto){
        Repair repair = repository.getReferenceById(dto.id());
        repair.updateInfo(dto);

        return ResponseEntity.ok(new DtoDataRepair(repair));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Repair repair = repository.getReferenceById(id);

        repair.delete();

        return ResponseEntity.noContent().build();
    }
}
