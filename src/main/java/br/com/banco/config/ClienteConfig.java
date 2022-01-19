package br.com.banco.config;

import br.com.banco.model.ClienteModel;
import br.com.banco.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClienteConfig {
    @Bean
        // o spring conteiner vai gerenciar e criar as instancias dessa classe de uma biblioteca externa
    CommandLineRunner commandLineRunner(ClienteRepository clienteRepository) { //?
        return args -> {
            ClienteModel abel = new ClienteModel(1,"Pedro", "879.054.950-35", "(15)98143-4545","Rua Melo Peixe");
            ClienteModel livia = new ClienteModel(2,"Livia", "474.838.800-58", "(11)98122-2455","Rua Joao Alves");
            clienteRepository.saveAll(List.of(abel, livia));
        };
    }
}
