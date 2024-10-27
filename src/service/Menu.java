package service;

import model.Cliente;
import model.Livro;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    private SysLivraria biblioteca = new SysLivraria();
    private SysCliente clientes = new SysCliente();
    private int opcao;
    private DateTimeFormatter brasilPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Menu() {
        menuOptions();
    }

    private void menuOptions() {
        while (true) {
            try {
                System.out.println("Bem vindo ao menu principal da biblioteca.");
                System.out.println("Digite o que você deseja fazer na biblioteca:");
                System.out.println("1 - Adicionar um livro");
                System.out.println("2 - Remover um livro");
                System.out.println("3 - Listar livros");
                System.out.println("4 - Alugar livro");
                System.out.println("5 - Listar livros disponíveis");
                System.out.println("6 - Listar livros alugados");
                System.out.println("7 - Devolver um livro");
                System.out.println("8 - Cadastrar um cliente");
                System.out.println("9 - Sair");
                System.out.print("Digite o numero de sua escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 9) {
                    break;
                }

                switch (opcao) {
                    case 1:
                        adicionarLivro();
                        break;
                    case 2:
                        removerLivro();
                        break;
                    case 3:
                        biblioteca.listarLivros();
                        break;
                    case 4:
                        alugarLivro();
                        break;
                    case 5:
                        biblioteca.listarLivrosDisponiveis();
                        break;
                    case 6:
                        biblioteca.listarLivrosAlugados();
                        break;
                    case 7:
                        devolverLivro();
                        break;
                    case 8:
                        cadastrarCliente();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você só pode utilizar números inteiros!");
                sc.nextLine(); // Limpar a entrada inválida
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o nome do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Digite a sinopse: ");
        String desc = sc.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine();
        System.out.print("Digite a data de publicação (dia/mês/ano): ");
        String data = sc.nextLine();
        LocalDate date = LocalDate.parse(data, brasilPadrao);
        biblioteca.addLivro(titulo, desc, autor, date);
    }

    private void removerLivro() {
        System.out.print("Digite o nome do livro que deseja remover: ");
        String nome = sc.nextLine();
        biblioteca.removeLivroNome(nome);
    }

    private void alugarLivro() {
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = sc.nextLine();
        System.out.print("Digite o nome do Cliente: ");
        String nomeCliente = sc.nextLine();

        Cliente cliente = clientes.getClientes().stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            biblioteca.emprestimoLivro(nomeLivro, cliente);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void devolverLivro() {
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = sc.nextLine();
        System.out.print("Digite o nome do Cliente: ");
        String nomeCliente = sc.nextLine();

        Cliente cliente = clientes.getClientes().stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            biblioteca.devolverLivro(nomeLivro, cliente);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();
        clientes.criarCliente(nome, cpf, telefone);
    }
}
