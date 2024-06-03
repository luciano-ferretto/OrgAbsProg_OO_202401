public class Main {
    public static void main(String[] args) {
        Cesta cestaFrutas = new Cesta(10);
        cestaFrutas.inserir(new Fruta("Maçã"));
        cestaFrutas.inserir(new Fruta("Pera"));
        cestaFrutas.inserir(new Fruta("laranja"));
        fazerSaladaDeFrutas(cestaFrutas);
    }

    public static Fruta[] fazerSaladaDeFrutas(Cesta cestaFrutas) {
        Fruta[] salada = new Fruta[20];
        int i = 0;
        while (cestaFrutas.exiteItens()) {
            Fruta fruta = (Fruta) cestaFrutas.getProximo();
            fruta.cortar();
            salada[i++] = fruta;
        }
        return salada;
    }
}

