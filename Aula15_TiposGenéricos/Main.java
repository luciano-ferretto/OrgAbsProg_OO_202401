import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        Map<Integer, Fruta> mapaFrutas;


        Cesta<FrutaTropical> frutasTropicais = new Cesta<>(20);
        frutasTropicais.inserir(new FrutaTropical("Jaca"));
        fazerSaladaDeFrutas(frutasTropicais);

        Cesta<Fruta> cestaFrutas = new Cesta<>(10);
        cestaFrutas.inserir(new Fruta("Maçã"));
        cestaFrutas.inserir(new Fruta("Pera"));
        cestaFrutas.inserir(new Fruta("laranja"));
        cestaFrutas.inserir(new FrutaTropical("Jaca"));
        fazerSaladaDeFrutas(cestaFrutas);

        Cesta<Gato> cestaGatos = new Cesta<>(20);
        //fazerSaladaDeFrutas(cestaGatos);
    }

    public static Fruta[] fazerSaladaDeFrutas(Cesta<? extends Fruta> cestaFrutas) {
        Fruta[] salada = new Fruta[20];
        int i = 0;
        while (cestaFrutas.exiteItens()) {
            Fruta fruta = cestaFrutas.getProximo();
            fruta.cortar();
            salada[i++] = fruta;
        }
        return salada;
    }
}

