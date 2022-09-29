public class Main {
    public static void main(String[] args) {
        Cliente raphael = new Cliente();
        raphael.setNome("Raphael");


        Conta corrente = new ContaCorrente(raphael);
        Conta poupanca = new ContaPoupanca(raphael);

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
