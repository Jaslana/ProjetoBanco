package br.com.banco.dto.requestDto;

import br.com.banco.model.OperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //responsável por gerar um conjunto de anotações como @ToString, @EqualsAndHashCode, @Getter, @Setter e @RequiredArgsConstructor.
@AllArgsConstructor //responsável por gerar um construtor com 1 parâmetro para cada atributo de sua classe
@NoArgsConstructor //responsável por gerar um construtor sem parâmetros
public class OperacaoRequestDto {

    public String numeroConta;
    public double valor;
    public double taxa;
    private OperacaoEnum tipoOperacao;

}
