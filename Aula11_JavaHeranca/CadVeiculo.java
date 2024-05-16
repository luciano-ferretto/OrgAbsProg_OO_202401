import java.util.Arrays;
import java.util.List;

public class CadVeiculo {
    public static void main(String[] args) {

        Veiculo uno = new Carro("Fiat", "Uno", 2005, 4);
        Veiculo fusca = new Carro("Volkswagen", "Fusca", 1995, 2);
        Veiculo falcon = new Moto("Honda", "Falcon NX 400", 2000, true);
        
        imprimirVeiculos(Arrays.asList(uno, fusca, falcon));

    }

    private static void imprimirVeiculos(List<Veiculo> veiculos) {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
            System.out.println("Tempo de uso: " +  veiculo.calcularTempoDeUso() + " ano(s)");
            System.out.println(veiculo.calcularImposto());
        }
    }
}
