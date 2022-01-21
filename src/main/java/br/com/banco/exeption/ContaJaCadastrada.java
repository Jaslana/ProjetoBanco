package br.com.banco.exeption;

public class ContaJaCadastrada extends RuntimeException{
    public ContaJaCadastrada (String mensagem) {
        super(mensagem);
    }
}
