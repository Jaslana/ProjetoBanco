package br.com.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="operacao")
public class OperacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11)
    public String numeroConta;

    @Column
    public double valor;

    @Column
    public double taxa;

    @Enumerated(EnumType.ORDINAL) //mapeia a enumeraçao
    private OperacaoEnum tipoOperacao; //classe contendo extrato,saque,transferência

}
