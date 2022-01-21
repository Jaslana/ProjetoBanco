package br.com.banco.controller;

import br.com.banco.dto.requestDto.ContaRequestDto;
import br.com.banco.dto.responseDto.ContaResponseDelete;
import br.com.banco.dto.responseDto.ContaResponseDto;
import br.com.banco.dto.responseDto.ContasClienteResponse;
import br.com.banco.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ContaController {
    private final ContaService contaService;

    @PostMapping(path = "/conta/salvar") //SALVAR
    public ContaResponseDto salvarConta(@RequestBody @Valid ContaRequestDto contaRequestDto) {
        return contaService.salvarConta(contaRequestDto);
    }

    @GetMapping(path = "/contas/consultar") //LISTAR TODOS
    public List<ContaResponseDto> consultarTodos() {
        return contaService.consultarTodos();
    }
    @GetMapping(path = "/conta/pesquisar") //CONSULTAR POR NumConta
    public ContasClienteResponse consutarNumConta(@RequestParam String numConta) { //PESQUISAR POR mumero da conta
        return contaService.consutarNumConta(numConta);
    }
    @PutMapping("/conta/alterar") //ATUALIZAR
    public ContaResponseDto atualizarConta(@RequestParam String numConta, @RequestBody ContaRequestDto contaRequestDto) {
        return contaService.atualizarConta(numConta, contaRequestDto);
    }
    @DeleteMapping(value = "/conta/deletar") //DELETAR
    public ContaResponseDelete deletarConta(@RequestParam String numConta){
        return contaService.deletarConta(numConta);
    }
}
