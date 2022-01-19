package br.com.banco.repository;

import br.com.banco.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository <ContaModel, Integer> {
  List<ContaModel> findAllByClienteCpf(String cpf);
}