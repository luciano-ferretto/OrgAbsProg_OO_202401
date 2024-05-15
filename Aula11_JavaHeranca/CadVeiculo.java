import java.util.Arrays;
import java.util.List;

public class CadVeiculo {
    public static void main(String[] args) {

        Veiculo uno = new Veiculo("Fiat", "Uno", 2003);

        Veiculo fusca = new Veiculo();
        fusca.setMarca("Volkswagen");
        fusca.setModelo("Fusca");
        fusca.setAno(1995);

        imprimirVeiculos(Arrays.asList(uno, fusca));

    }

    private static void imprimirVeiculos(List<Veiculo> veiculos) {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
            System.out.println("Tempo de uso: " +  veiculo.calcularTempoDeUso() + " ano(s)");
        }
    }
}
