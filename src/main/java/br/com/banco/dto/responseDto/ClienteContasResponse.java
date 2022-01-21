package br.com.banco.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClienteContasResponse {
    ClienteResponseDto cliente; //OK
    List<ContaResponseDto> contas; //EXIBE COMO RESPOSTA NO POSTSMAN O CAMPO contas ATRELADO A UM VALOR EM CLIENTE SERVICE lista
}
