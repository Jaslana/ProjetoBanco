package br.com.banco.exeption;

public class CpfJaCadastrado extends RuntimeException{
    public CpfJaCadastrado (String mensagem) {
        super(mensagem);
    }
}
