package br.com.banco.service;

import br.com.banco.taxa.TaxaTransacoes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/operacoes")

public class OperacaoService extends TaxaTransacoes {
}