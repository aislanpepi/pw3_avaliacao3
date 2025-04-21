package br.edu.ifsp.prw3.avaliacao3.persistence;

import br.edu.ifsp.prw3.avaliacao3.model.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair,Long> {
    Page<Repair> findAllByActiveTrue(Pageable pageable);
    List<Repair> findAllByActiveTrue();
}
