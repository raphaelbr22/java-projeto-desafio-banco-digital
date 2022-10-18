public class Cliente {
    protected int conta;
    private String nome;
    private String cpf;
    private String senha;

//    public Cliente(){}

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

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

    public int getConta() {
        return conta;
    }

    public void setConta(int numberConta) {
        this.conta = numberConta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "conta=" + conta +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}