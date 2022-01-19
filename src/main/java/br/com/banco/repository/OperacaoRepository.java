package br.com.banco.repository;

import br.com.banco.model.OperacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<OperacaoModel, Long> {
}