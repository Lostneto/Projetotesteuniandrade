package Projetouniandrade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projetouniandrade.domain.Residuo;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Integer> {

}
