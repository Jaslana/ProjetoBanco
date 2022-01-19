package br.com.banco.exeption;

public class CpfNaoEncontrado extends RuntimeException {
    public CpfNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
