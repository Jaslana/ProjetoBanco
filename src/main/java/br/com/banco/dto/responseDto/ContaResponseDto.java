package br.com.banco.dto.responseDto;

import br.com.banco.model.ContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponseDto { // a resposta com os campos que sera exibida no postman

    private String agencia;
    private String numConta;
    private ContaEnum tipo;
    private Integer digitoVerifador;
//  private String clienteCpf; // exibe como resposta quando requisitado o campo clienteCpf no postaman
    private double saldo;
}
