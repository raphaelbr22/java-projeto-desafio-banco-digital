import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        System.out.println("Bem vindo ao Alra Bank!");
        System.out.println("Já é nosso cliente? Digite 1 para entrar na sua conta.");
        System.out.println("Ou digite 2 se ainda não possui conta e deseja fazer cadastro.");

        int escolha = opcao.nextInt();
                
        if(escolha == 2){
            Cliente.cadastroCliente();
            Conta.criarConta();
        }else if(escolha == 1){
            loginCliente();
        }
    }    
    private static void loginCliente() {
    }
}

