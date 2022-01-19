package br.com.banco.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClienteContasResponse {
    ClienteResponseDto cliente;
    List<ContaResponseDto> contas; //UTILIZA NO CLIENTE SERVICE lista
}
