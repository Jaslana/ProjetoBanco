package br.com.banco.dto.responseDto;

import br.com.banco.model.ContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponseDto { // a resposta com os campos que sera exibida no postman

    public  String agencia;
    public  String numConta;
    public  ContaEnum tipo;
    public  Integer digitoVerifador;
    //  private String clienteCpf; // exibe como resposta quando requisitado o campo clienteCpf no postaman
    public double saldo;
}
