import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    protected int conta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    } 

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }          
    public static void cadastroCliente() {
        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("Digite seu nome: ");
        cliente.setNome(entrada.nextLine()); 
        System.out.println("Digite seu CPF: ");
        cliente.setCpf(entrada.nextLine()); 
        System.out.println("Ótimo! Agora vamos escolher uma conta para você.");
    }

}

