package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacit.api.entity.Estacao;
<<<<<<< Updated upstream
=======
import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;
>>>>>>> Stashed changes

public interface EstacaoRepository extends JpaRepository<Estacao, String> {
<<<<<<< Updated upstream

=======
@Query(value = "select * from estacao", nativeQuery = true)

public List<Estacao> selectEstacao();
>>>>>>> Stashed changes
}
