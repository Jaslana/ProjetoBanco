package br.com.banco.dto.responseDto;

import br.com.banco.model.ContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponseDto {

    public String agencia;
    public String numConta;
    public ContaEnum tipo;
    public Integer digitoVerifador;
    public String clienteCpf;
    public double saldo;
}
