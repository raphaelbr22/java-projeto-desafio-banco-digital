import java.util.Scanner;

public abstract class Conta implements IConta{
    
    private static final String AGENCIA_PADRAO = "0001";
    private static int SEQUENCIAL = 1;
   
    protected String agencia; 
    protected int numero;   
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this. numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;        
    }
    @Override
    public void depositar(double valor) {
        saldo += valor;
        
    }
    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
   
   
    public String getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %s", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void criarConta() {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Digite 1 para criar uma conta corrente, ou 2 para conta poupança:");
            int escolha = entrada.nextInt();
            if(escolha == 1) {
            Conta corrente = new ContaCorrente(cliente);
            }else if(escolha == 2){
            Conta poupanca = new ContaPoupanca(cliente);
            }else{
            throw new ParametrosInvalidosException();
            }
        } catch (ParametrosInvalidosException exception) {
            System.out.println("Escolha uma opção válida.");
        }
    }
    
}
