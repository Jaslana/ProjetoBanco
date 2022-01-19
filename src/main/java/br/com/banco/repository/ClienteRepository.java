package br.com.banco.repository;

import br.com.banco.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel, Integer>{ //ESTENDENDO A dependencia jpa e vai pegar da classe ClienteModel
    @Query("SELECT s FROM ClienteModel s WHERE s.cpf = ?1") //clienteconfig funcionar
    ClienteModel getByCpf (String cpf);
    Optional<ClienteModel> findByCpf(String cpf); //sera usado para pesquisa no cliente service
}