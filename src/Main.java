import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParametrosInvalidosException {
        try (Scanner opcao = new Scanner(System.in)) {
            System.out.println("Bem vindo ao Alra Bank!");
            System.out.println("Já é nosso cliente? Digite 1 para entrar na sua conta.");
            System.out.println("Ou digite 2 se ainda não possui conta e deseja fazer cadastro.");

            int escolha = opcao.nextInt();
                
            if(escolha == 2){
                cadastroCliente();
                Cliente.criarConta();
            }else if(escolha == 1){
                loginCliente();
            }else{
                throw new ParametrosInvalidosException();
            }
            //corrente.imprimirExtrato();
            //poupanca.imprimirExtrato();
        }
        catch(ParametrosInvalidosException exception){
            System.out.println("Escolha uma opção válida.");
        }
    }    
    private static void loginCliente() {
    }

    public static void cadastroCliente() {
        try (Scanner entrada = new Scanner(System.in)) {
            Cliente cliente = new Cliente();
            System.out.println("Digite seu nome: ");
            cliente.setNome(entrada.nextLine()); 
            System.out.println("Digite seu CPF: ");
            cliente.setCpf(entrada.nextLine()); 
        }
    }
}

