package br.com.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //para utilizar na classe dto
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50) //mepeando o que e coluna
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Column(length = 50)
    private String endereco;

}
