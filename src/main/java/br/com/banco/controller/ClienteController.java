package br.com.banco.controller;

import br.com.banco.dto.requestDto.ClienteRequestDto;
import br.com.banco.dto.responseDto.ClienteContasResponse;
import br.com.banco.dto.responseDto.ClienteResponseDelete;
import br.com.banco.dto.responseDto.ClienteResponseDto;
import br.com.banco.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor

public class ClienteController { //envia os metodos

    private final ClienteService clienteService;

    @PostMapping(path = "/cliente/salvar") //SALVAR CLIENTE
    public ResponseEntity<ClienteResponseDto> salvarCliente(@RequestBody @Valid ClienteRequestDto clienteRequestDto) {
        return clienteService.salvarCliente(clienteRequestDto);
    }
    @GetMapping(path = "/cliente/consultar") //LISTAR TODOS CLIENTE
    public List<ClienteResponseDto> consultarTodos() {
        return clienteService.consultarTodos();
    }
    @GetMapping(path = "/clientes/pesquisar") //CONSULTAR POR CPF
    public ClienteContasResponse consultarCpf(@RequestParam String cpf) { //PESQUISAR POR CPF CLIENTE
        return clienteService.consultarCpf(cpf);
    }
    @PutMapping("/cliente/alterar") //ATUALIZAR
    public ClienteResponseDto atualizarCliente(@RequestParam String cpf, @RequestBody ClienteRequestDto clienteRequestDto) {
        return clienteService.atualizarCliente(cpf, clienteRequestDto);
    }
    @DeleteMapping(value = "/cliente/deletar") //DELETAR
    public ClienteResponseDelete delete(@RequestParam String cpf){
        return clienteService.delete(cpf);
    }
}
