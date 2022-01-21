package br.com.banco.service;

import br.com.banco.dto.requestDto.ContaRequestDto;
import br.com.banco.dto.responseDto.ClienteResponseDto;
import br.com.banco.dto.responseDto.ContaResponseDelete;
import br.com.banco.dto.responseDto.ContaResponseDto;
import br.com.banco.dto.responseDto.ContasClienteResponse;
import br.com.banco.exeption.ContaJaCadastrada;
import br.com.banco.exeption.ContaNaoEncontrada;
import br.com.banco.model.ClienteModel;
import br.com.banco.model.ContaModel;
import br.com.banco.repository.ClienteRepository;
import br.com.banco.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service //semanticamente anotamos como service que vai receber repository
@RequiredArgsConstructor //

public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;


    public ContaResponseDto salvarConta(ContaRequestDto contaRequestDto) {
        ContaModel model = modelMapper.map(contaRequestDto, ContaModel.class);
        ContaResponseDto contaResponse = modelMapper.map(model, ContaResponseDto.class);

        ContaModel contaExistente = contaRepository.getByNumConta(model.getNumConta()); //Repository

        if (!Objects.isNull(contaExistente)) {
            throw new ContaJaCadastrada("Numero de conta: " + model.getNumConta() + " ja cadastrada no sistema");
        }
        model.setClienteCpf(contaRequestDto.getClienteCpf());
        contaRepository.save(model);
        return contaResponse; //retorna o status com o corpo completo
    }

    public List<ContaResponseDto> consultarTodos() {
        return contaRepository.findAll()
                .stream()
                .map(this::toContaResponseDto)
                .collect(Collectors.toList());

        //retornar que nao existe nenhuma conta
    }
    public ContaResponseDto toContaResponseDto(ContaModel contaModel) {

        var contaResponseDto = new ContaResponseDto();
        contaResponseDto.setAgencia(contaModel.getAgencia());
        contaResponseDto.setNumConta(contaModel.getNumConta());
        contaResponseDto.setTipo(contaModel.getTipo());
        contaResponseDto.setDigitoVerifador(contaModel.getDigitoVerifador());
//      contaResponseDto.setClienteCpf(contaModel.getClienteCpf()); //seria exibido o valor atrelado ao campo no postman se no contaresponsedto estivesse criado o campo ClienteCpf com os get e set
        contaResponseDto.setSaldo(contaModel.getSaldo());
//      contaResponseDto.setQtdSaques(contaModel.getQtdSaques());

        return contaResponseDto;
    }

    public ContasClienteResponse consutarNumConta(String numConta) {
        ContaModel conta = contaRepository.findByNumConta(numConta).orElseThrow(() ->
                new ContaNaoEncontrada("Conta nao encontrado " + numConta));
        ClienteModel cliente = clienteRepository.getByCpf(conta.getClienteCpf());
        return ContasClienteResponse.builder()
                .contas(modelMapper.map(conta, ContaResponseDto.class))
                .cliente(modelMapper.map(cliente, ClienteResponseDto.class)).build();
    }

    public ContaResponseDto atualizarConta(String numConta, ContaRequestDto contaRequestDto) {
        contaRequestDto.setNumConta(numConta);
        ContaModel model = modelMapper.map(contaRequestDto, ContaModel.class);

        contaRepository.findByNumConta(model.getNumConta()).map(map -> {
            map.setAgencia(model.getAgencia());
            map.setTipo(model.getTipo());
            map.setDigitoVerifador(model.getDigitoVerifador());
            map.setSaldo(model.getSaldo());
            ContaModel updated = contaRepository.save(map);
            return updated;
        });
        ContaResponseDto contaResponse = modelMapper.map(model, ContaResponseDto.class);

        return contaResponse;
    }

    public ContaResponseDelete deletarConta(String numConta) {

        ContaModel model = contaRepository.findByNumConta(numConta).orElseThrow(() ->
                new ContaNaoEncontrada("Conta nao encontrado com o numero de conta : " + numConta));

        contaRepository.delete(model);
        ContaResponseDto contaResponseDto = modelMapper.map(model, ContaResponseDto.class);
        return ContaResponseDelete.builder()
                .mensagem("Conta Deletada com sucesso!")
                .contaDeletada(contaResponseDto).
                build();
    }
}



