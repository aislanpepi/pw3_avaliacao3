package br.edu.ifsp.prw3.avaliacao3.persistence;

import br.edu.ifsp.prw3.avaliacao3.model.UserMechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserMechanic,Long> {
    UserDetails findByLogin(String username);
}
