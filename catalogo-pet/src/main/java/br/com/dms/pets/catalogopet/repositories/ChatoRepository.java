package br.com.dms.pets.catalogopet.repositories;

import br.com.dms.pets.catalogopet.models.Cadastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatoRepository extends JpaRepository <Cadastre, Integer> {
}
