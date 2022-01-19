package br.com.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta")
public class ContaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 4) //mepeando
    private String agencia;

    @Column(length = 11)
    private String numConta;

    @Column
    @Enumerated(EnumType.ORDINAL) //mapeia a enumeraçao
    private ContaEnum tipo; //uso a classe como tipo

    @Column
    private Integer digitoVerifador;

    @Column
    private String clienteCpf;

    @Column
    private double saldo;

    @Column
    private Integer qtdSaques; // sera utilizado em taxatransaçoes
}
