public class ContaCorrente extends Conta {

    public ContaCorrente(Conta corrente) {
        super(corrente);
    }

    public ContaCorrente(Cliente cliente) {
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        
    }    
    
}
