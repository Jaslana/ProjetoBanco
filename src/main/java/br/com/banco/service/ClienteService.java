package br.com.banco.service;

import br.com.banco.dto.requestDto.ClienteRequestDto;
import br.com.banco.dto.responseDto.ClienteContasResponse;
import br.com.banco.dto.responseDto.ClienteResponseDelete;
import br.com.banco.dto.responseDto.ClienteResponseDto;
import br.com.banco.dto.responseDto.ContaResponseDto;
import br.com.banco.exeption.CpfNaoEncontrado;
import br.com.banco.exeption.CpfJaCadastrado;
import br.com.banco.model.ClienteModel;
import br.com.banco.model.ContaModel;
import br.com.banco.repository.ClienteRepository;
import br.com.banco.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service //semanticamente anotamos como service que vai receber repository
@RequiredArgsConstructor //
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository; // sera utilizado para pesquisa
    private final ModelMapper modelMapper; // sera utilizado na pesquisa

    public ResponseEntity<ClienteResponseDto> salvarCliente(ClienteRequestDto clienteRequestDto) {

//modelmapper feito na mao estamos trasformando model para request
        ClienteModel model = new ClienteModel();
        model.setNome(clienteRequestDto.getNome());
        model.setEndereco(clienteRequestDto.getEndereco());
        model.setTelefone(clienteRequestDto.getTelefone());
        model.setCpf(clienteRequestDto.getCpf());

//reponse para model
        ClienteResponseDto resDto = new ClienteResponseDto();
        resDto.setNome(model.getNome());
        resDto.setEndereco(model.getEndereco());
        resDto.setTelefone(model.getTelefone());
        resDto.setCpf(model.getCpf());
//lambda
        ClienteModel cpfExiste = clienteRepository.getByCpf(model.getCpf());
        if(!Objects.isNull(cpfExiste)){
            throw new CpfJaCadastrado("Cpf já cadastrado no sistema"); //captura a mensagem de erro
        }
        clienteRepository.save(model); // se nao salva

        return ResponseEntity.status(HttpStatus.CREATED).body(resDto); //retorna o status com o corpo completo
    }

    public List<ClienteResponseDto> consultarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toClienteoResponseDto)
                .collect(Collectors.toList());
    }

    public ClienteResponseDto toClienteoResponseDto(ClienteModel clienteModel) {
        var clienteResponseDto = new ClienteResponseDto();
        clienteResponseDto.setNome(clienteModel.getNome());
        clienteResponseDto.setCpf(clienteModel.getCpf());
        clienteResponseDto.setTelefone(clienteModel.getTelefone());
        clienteResponseDto.setEndereco(clienteModel.getEndereco());
        return clienteResponseDto;
    }
    public ClienteContasResponse consultarCpf(String cpf) {
       ClienteModel model = clienteRepository.findByCpf(cpf).orElseThrow(() ->
               new CpfNaoEncontrado("Usuario nao encontrado com o CPF: " + cpf));
        List<ContaModel> contas = contaRepository.findAllByClienteCpf(cpf); //vai pegar do repository
        List<ContaResponseDto> contasresponse = Arrays.asList();
        contas.forEach(item ->{
            contasresponse.add(modelMapper.map(item,ContaResponseDto.class));
        });
        return ClienteContasResponse.builder()
                .cliente(modelMapper.map(model,ClienteResponseDto.class)) //ClienteContaResponse
                .contas(contasresponse).build();  //ClienteContaResponse contas do cliente
    }
    public ClienteResponseDto atualizarCliente(String cpf, ClienteRequestDto clienteRequestDto) {
        clienteRequestDto.setCpf(cpf);
        ClienteModel cpfNaoExiste = clienteRepository.findByCpf(cpf).orElseThrow(() ->
                new CpfNaoEncontrado("Usuario nao encontrado com o CPF: " + cpf));
        ClienteModel model = modelMapper.map(clienteRequestDto, ClienteModel.class);

        clienteRepository.findByCpf(model.getCpf()).map(map -> {
            map.setNome(model.getNome());
            map.setCpf((cpf));
            map.setTelefone(model.getTelefone());
            map.setEndereco(model.getEndereco());
            ClienteModel updated = clienteRepository.save(map);
            return updated;
        });
        ClienteResponseDto clienteResponseDto = modelMapper.map(model, ClienteResponseDto.class);

        return clienteResponseDto;
    }
    public ClienteResponseDelete delete(String cpf) {

        ClienteModel model = clienteRepository.findByCpf(cpf).orElseThrow(() ->
                new CpfNaoEncontrado("Usuario nao encontrado com o CPF: " + cpf));

        clienteRepository.delete(model);
        ClienteResponseDto clienteResponseDto = modelMapper.map(model, ClienteResponseDto.class);
        return ClienteResponseDelete.builder()
                .mensagem("Conta Deletada com sucesso!")
                .clienteDeletado(clienteResponseDto).
                build();
    }
}
