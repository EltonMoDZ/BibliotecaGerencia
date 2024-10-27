package model;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private ArrayList<Livro> livrosAlugados;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        livrosAlugados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public ArrayList<Livro> getLivrosAlugados() {
        return livrosAlugados;
    }

    public void rmLivrosAlugados(Livro livro) {
        this.livrosAlugados.remove(livro);
    }

    public void addLivrosAlugados(Livro livro) {
        this.livrosAlugados.add(livro);
    }
}
