package br.com.banco.repository;

import br.com.banco.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository <ContaModel, Integer> {
  List<ContaModel> findAllByClienteCpf(String cpf);
  ContaModel getByNumConta (String numConta);//sera usado na conta service para ver se exixte num da conta
  Optional<ContaModel> findByNumConta(String numConta); // sera usado na conta service em consultar
}