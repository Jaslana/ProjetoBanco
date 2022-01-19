package br.com.banco.dto.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponseDelete {
    ClienteResponseDto clienteDeletado;
    String mensagem;
}

