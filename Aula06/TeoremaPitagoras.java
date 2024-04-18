import java.util.Scanner;

public class TeoremaPitagoras {
    public static void main(String[] args) {
        Scanner lerTeclador = new Scanner(System.in);
        System.out.println("Informe o valor do cateto A");
        double catetoA = lerTeclador.nextDouble();
        System.out.println("Informe o valor do Cateto B");
        double catetoB = lerTeclador.nextDouble();
        catetoA = catetoA * catetoA;
        catetoB = Math.pow(catetoB,2);
        double hipotenusa = Math.sqrt(catetoA + catetoB);
        System.out.print("O valor da Hipotenusa é: " + hipotenusa);
    }
}
