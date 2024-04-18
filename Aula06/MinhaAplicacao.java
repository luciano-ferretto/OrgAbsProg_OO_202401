import java.util.Scanner;

public class MinhaAplicacao {
    public static void main(String[] args) {
        double raiz = Math.sqrt(481); //

        Scanner lerTeclado = new Scanner(System.in);
        System.out.println("Digite o primeiro valor:");
        int variavel01 = lerTeclado.nextInt();
        System.out.println("Digite o segundo valor: ");
        int variavel02 = lerTeclado.nextInt();
        int variavel03 = soma(variavel01,variavel02);
        imprimeTela(variavel03);
        lerTeclado.close();
    }
    public static int soma(int valor1, int valor2){
        return valor1 + valor2;
    }
    public static void imprimeTela(int valor){
        System.out.println("O Valor é: " + valor);
    }
}

