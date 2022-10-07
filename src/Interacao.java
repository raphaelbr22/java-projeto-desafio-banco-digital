import java.util.ArrayList;
import java.util.Scanner;

public class Interacao {
    private static final Scanner scan = new Scanner(System.in);
    private Banco bank = null;

    public Interacao() {
    }

    public Interacao(String nomeBanco) {
        this.bank = new Banco();
        this.bank.setNome(nomeBanco);
        this.bank.setContas(new ArrayList<>());
    }

    public void start() {
        if (this.bank == null) {
            System.out.println("O banco atual esta indefinido, deseja configurar ele? ");
            System.out.println("1 - Sim;");
            System.out.println("2 - Não;");
            if (scan.nextInt() != 1) return;
            setBanco();
        }
        System.out.println("\nBem vindo ao " + this.bank.getNome() + "!");
        System.out.println("Já é nosso cliente?");
        System.out.println("Digite 0 para sair do sistema.");
        System.out.println("Digite 1 para entrar na sua conta.");
        System.out.println("Digite 2 se ainda não possui conta e deseja fazer cadastro.");
        int escolha = Integer.parseInt(scan.nextLine());

        if (escolha == 1) {
            menuContas();
        } else if (escolha == 2) {
            menuCadastroCliente();
        }
        if (escolha == 0) System.out.println("Até a próxima!");
        else start();
    }

    private void menuCadastroCliente() {
        Cliente c = novoCliente();
        System.out.println("Ótimo! Agora vamos escolher uma conta para você.");
        menuCadastroConta(c);
    }

    public void menuCadastroConta(Cliente cliente) {
        int opt;
        Conta c = null;
        do {
            System.out.println("Escolha 1 para Conta Corrente;");
            System.out.println("Escolha 2 para Conta Poupança;");
            opt = Integer.parseInt(scan.nextLine());
            if (opt == 1) {
                c = new ContaCorrente(cliente);
            } else if (opt == 2) {
                c = new ContaPoupanca(cliente);
            }
            if (opt != 1 && opt != 2) {
                System.out.println("Opção inválida");
            }
        } while (opt < 1 || opt > 2);
        cliente.setConta(c.numero);
        this.bank.getContas().add(c);
    }

    private Cliente novoCliente() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        var nome = entrada.nextLine();
        System.out.print("Digite seu CPF: ");
        var cpf = entrada.nextLine();
        System.out.print("Digite uma senha de 6 dígitos numéricos: ");
        var senha = entrada.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        cliente.setSenha(senha);
        return cliente;
    }

    private Conta contaCliente(String cpf) {
        for (var conta : this.bank.getContas()) {
            if (conta.cliente.getCpf().equals(cpf)) return conta;
        }
        return null;

    }

    private void menuContas() {
        if (this.bank.getContas().size() > 0) {
            String opt;
            while (true) {
                System.out.print("Digite seu cpf para buscarmos a conta: ");
                opt = scan.nextLine();
                Conta cCliente = contaCliente(opt);
                if (cCliente != null) {
                    menuGerenciaConta(cCliente);
                    break;
                } else {
                    System.out.println("Não achamos sua conta.");
                    System.out.print("Digite 0 para desistir: ");
                    if (scan.nextLine().equals("0")) break;
                }
            }
        } else System.out.println("Não há contas cadastradas nesse banco " + this.bank.getNome());
    }

    public void menuGerenciaConta(Conta conta) {
        String opt;
        while (true) {
            System.out.println("Digite 1 para visualizar a conta");
            System.out.println("Digite 2 para editar a conta");
            System.out.println("Digite 0 para sair");
            opt = scan.nextLine();
            if (opt.equals("1")) {
                System.out.println(conta);
            } else if (opt.equals("2")) {
                menuEdicaoConta(conta);
            } else break;
        }
    }

    private void menuEdicaoConta(Conta conta) {
        int opt;
        do {
            System.out.println("Digite 0 para Sair;");
            System.out.println("Digite 1 para Saldo;");
            System.out.println("Digite 2 para Saque;");
            System.out.println("Digite 3 para transferência;");
            opt = Integer.parseInt(scan.nextLine());
            switch (opt) {
                case 0:
                    System.out.println("Saindo do menu de Edição da Conta.");
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opt != 0);
    }

    private Conta buscaConta(int numeroConta) {
        for (var c : this.bank.getContas()) {
            if (numeroConta == c.getNumero()) return c;
        }
        return null;
    }

    private void setBanco() {
        System.out.print("Escolha o nome do banco: ");
        this.bank = new Banco();
        this.bank.setNome(new java.util.Scanner(System.in).nextLine());
        this.bank.setContas(new ArrayList<>());
    }
}