package br.com.banco.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {

    public String nome;
    public String cpf;
    public String telefone;
    public String endereco;
}
