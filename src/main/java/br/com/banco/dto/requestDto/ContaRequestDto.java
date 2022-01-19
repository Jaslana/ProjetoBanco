package br.com.banco.dto.requestDto;

import br.com.banco.model.ContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaRequestDto { //a solicitaçao dos campos que sera requisitada no postaman

    @NotNull
    @NotEmpty
    private String agencia;

    @NotEmpty
    private String numConta;

    @NotNull
    private ContaEnum tipo;

    @Max(value = 99)
    @NotNull
    private Integer digitoVerifador;

    @CPF //Dependencia spring validation
    private String clienteCpf;  //campo é solicitado para ser atrelado a algum valor no postaman

    @NotNull
    private double saldo;

}
