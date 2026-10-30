package br.unieuro.estoque.excecao;

public class EstoqueException extends Exception {

    public EstoqueException(String mensagem) {
        super(mensagem);
    }

    public EstoqueException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}