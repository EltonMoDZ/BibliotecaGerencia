package service;

import model.Cliente;

import java.util.ArrayList;

public class SysCliente {
    public static ArrayList<Cliente> clientes;

    public SysCliente() {
        clientes = new ArrayList<>();
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void criarCliente(String nome, String cpf, String telefone){
        clientes.add(new Cliente(nome, cpf, telefone));
    }

    public void rmCliente(String cliente){
        for(Cliente c: clientes){
            if(cliente.equals(c.getNome())){
                clientes.remove(c);
            }
        }
    }

}
