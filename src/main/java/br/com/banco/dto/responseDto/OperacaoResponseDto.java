package br.com.banco.dto.responseDto;

import br.com.banco.model.OperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoResponseDto {

    public String numeroConta;
    public double valor;
    public double taxa;
    private OperacaoEnum tipoOperacao;

}