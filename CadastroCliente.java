package cadastroclientes;

/*A classe `Cliente` representa um cliente com atributos como nome, email e telefone.  
A classe `CadastroClientes` é responsável por gerenciar uma lista de clientes e oferecer
métodos para adicionar, visualizar, atualizar e excluir clientes.  */

import java.util.ArrayList;
import java.io.*;

public class CadastroClientes {
    private ArrayList<Cliente> clientes;
    protected final String arquivoClientes = "clientes.dat";

    public CadastroClientes() {
        clientes = new ArrayList<>();
        carregarClientes();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        salvarClientes();
    }

    public void visualizarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void atualizarCliente(int indice, Cliente novoCliente) {
        if (indice >= 0 && indice < clientes.size()) {
            clientes.set(indice, novoCliente);
            salvarClientes();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void excluirCliente(int indice) {
        if (indice >= 0 && indice < clientes.size()) {
            clientes.remove(indice);
            salvarClientes();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    protected void salvarClientes() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivoClientes));
            outputStream.writeObject(clientes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void carregarClientes() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivoClientes));
            clientes = (ArrayList<Cliente>) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            // Se o arquivo não existir ou houver um erro ao lê-lo, apenas ignore e crie um novo ArrayList
            clientes = new ArrayList<>();
        }
    }
}
