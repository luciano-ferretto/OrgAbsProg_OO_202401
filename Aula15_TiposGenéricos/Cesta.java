public class Cesta {
    private Object[] itens;
    private int tamanho;
    // Construtor para inicializar a cesta com um tamanho fixo
    public Cesta(int capacidade) {
        itens = new Object[capacidade];
        tamanho = 0;
    }
    // Método para inserir um objeto na cesta
    public void inserir(Object o) {
        if (tamanho < itens.length) {
            itens[tamanho++] = o;
        } else {
            System.out.println("Cesta cheia! Não é possível adicionar mais itens.");
        }
    }
    // Método para obter o último objeto adicionado na cesta e removê-lo (LIFO)
    public Object getProximo() {
        if (tamanho > 0) {
            Object item = itens[--tamanho];
            itens[tamanho] = null; // Remove referência para permitir garbage collection
            return item;
        } else {
            System.out.println("Não há mais itens na cesta.");
            return null;
        }
    }
    // Método para verificar se existem itens na cesta
    public boolean exiteItens() {
        return tamanho > 0;
    }
}




