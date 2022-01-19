package br.com.banco.dto.requestDto;

import br.com.banco.model.ContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaRequestDto {

    @NotNull
    @NotEmpty //Não permite valor nulo e além disso seu tamanho deve ser maior que zero
    private String agencia;

    @NotEmpty
    private String numConta;

    @NotNull //Não permite um valor nulo, porém permite um valor vazio.
    private ContaEnum tipo;

    @Max(value = 99) //Define o tamanho
    @NotNull
    private Integer digitoVerifador;

    @CPF //Dependencia spring validation
    @Min(11)
    private String clienteCpf;

    @NotNull
    private double saldo;

}
