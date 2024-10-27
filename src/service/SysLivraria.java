package service;

import model.Cliente;
import model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;

public class SysLivraria {
    private ArrayList<Livro> livros;
    private SysEmprestimo emprestimo = new SysEmprestimo();

    public SysLivraria() {
        livros = new ArrayList<>();
    }

    public void emprestimoLivro(String titulo, Cliente cliente) {
        emprestimo.emprestarLivro(titulo, cliente, livros);
    }

    public void addLivro(String titulo, String desc, String autor, LocalDate dataPublicacao) {
        livros.add(new Livro(titulo, desc, autor, dataPublicacao));
        System.out.println("Livro adicionado com sucesso!");
    }

    public void removeLivroNome(String titulo) {
        if (!livros.stream().anyMatch(livro -> livro.getTitulo().equalsIgnoreCase(titulo))) {
            System.out.println("Esse livro não existe");
            return;
        }
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Livro removido com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado");
            return;
        }
        System.out.println("Listando livros:");
        for (Livro livro : livros) {
            System.out.println("- " + livro.getTitulo() + " - Disponível: " + (livro.getDisponivel() ? "Sim" : "Não"));
        }
    }

    public void listarLivrosDisponiveis() {
        ArrayList<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível");
        } else {
            System.out.println("Livros disponíveis:");
            for (Livro livro : livrosDisponiveis) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }

    public void listarLivrosAlugados() {
        ArrayList<Livro> livrosAlugados = new ArrayList<>();
        for (Livro livro : livros) {
            if (!livro.getDisponivel()) {
                livrosAlugados.add(livro);
            }
        }
        if (livrosAlugados.isEmpty()) {
            System.out.println("Nenhum livro alugado");
        } else {
            System.out.println("Livros alugados:");
            for (Livro livro : livrosAlugados) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }

    public void devolverLivro(String titulo, Cliente cliente) {
        emprestimo.devolverLivro(titulo, cliente, livros);
    }

}