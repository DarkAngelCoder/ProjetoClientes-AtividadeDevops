package cadastroclientes;

/*A classe `Cliente` representa um cliente com atributos como nome, email e telefone.  
A classe `CadastroClientes` é responsável por gerenciar uma lista de clientes e oferecer
métodos para adicionar, visualizar, atualizar e excluir clientes.  */
 
import java.io.*;


class Cliente implements Serializable {
    private String nome;
    private String email;
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getTelefone() {
        return telefone;
    }
 
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
