package service;

import model.Cliente;
import model.Livro;

import java.util.ArrayList;

public class SysEmprestimo {

    public void emprestarLivro(String titulo, Cliente cliente, ArrayList<Livro> livros) {
        for (Livro livro1 : livros) {
            if (livro1.getTitulo().equalsIgnoreCase(titulo) && livro1.getDisponivel()) {
                cliente.addLivrosAlugados(livro1);
                livro1.setDisponivel(false);
                System.out.println("O livro foi emprestado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não disponível ou não encontrado.");
    }

    public void devolverLivro(String titulo, Cliente cliente, ArrayList<Livro> livros) {
        for (Livro livro1 : livros) {
            if (livro1.getTitulo().equalsIgnoreCase(titulo) && !livro1.getDisponivel()) {
                cliente.rmLivrosAlugados(livro1);
                livro1.setDisponivel(true);
                System.out.println("O livro foi devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado ou já disponível.");
    }

}