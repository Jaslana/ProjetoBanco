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
    private Integer id;

    private String clienteCpf;

    @Column(length = 11)
    private String numConta;

    @Column(length = 11) //mepeando
    private String agencia;

    private double saldo;

    private Integer qtdSaques; // sera utilizado em taxatransaçoes

    @Column
    private Integer digitoVerifador;

    @Column
    @Enumerated(EnumType.ORDINAL) //mapeia a enumeraçao
    private ContaEnum tipo; //uso a classe como tipo


}
