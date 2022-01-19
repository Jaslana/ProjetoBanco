package br.com.banco.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY )
//    private Integer id;

    @Size(min = 4, max = 35, message = "Esse campo deve conter o nome e sobrenome")
    @NotNull
    public String nome;

    @CPF
    public String cpf;

    @Size(min = 10, max = 14, message = "Esse campo um numero de telefone valido")
    @NotNull
    public String telefone;

    @Size(min = 4, max = 35, message = "Esse campo deve conter endereço")
    @NotNull
    public String endereco;
}
