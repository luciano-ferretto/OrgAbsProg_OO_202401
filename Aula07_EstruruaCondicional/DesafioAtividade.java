import java.util.Scanner;

public class DesafioAtividade {
    public static void main(String[] args) {
        limpaTela();
        double saldo = 1000;
        double chequeEspecial = 500;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Digite o valor do saque:");
            double saque = scan.nextDouble();
            scan.nextLine(); // Limpar o buffer
            if (saque <= saldo) {
                saldo = saldo - saque;
                System.out.println("Saque realizado com sucesso!");
            } else if (saque <= saldo + chequeEspecial) {
                chequeEspecial = chequeEspecial - (saque - saldo);
                saldo = 0;
                System.out.println("Saque realizado utilizando o Cheque Esepcial");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } catch (Exception e) {
            System.out.println("Valor digitado inválido");
        }
        System.out.println("Saldo atual: " + saldo);
        System.out.println("Cheque Especial: " + chequeEspecial);
    }

    public static void limpaTela() {
        System.out.println("\033[H\033[2J");
    }
}