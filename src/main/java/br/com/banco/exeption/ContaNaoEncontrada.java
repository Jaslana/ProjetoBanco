package br.com.banco.exeption;

public class ContaNaoEncontrada extends RuntimeException{
    public ContaNaoEncontrada (String mensagem) {
        super(mensagem);
    }
}
