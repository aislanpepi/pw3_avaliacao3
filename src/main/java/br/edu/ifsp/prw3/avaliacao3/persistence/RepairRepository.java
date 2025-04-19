package br.edu.ifsp.prw3.avaliacao3.persistence;

import br.edu.ifsp.prw3.avaliacao3.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair,Long> {
}
