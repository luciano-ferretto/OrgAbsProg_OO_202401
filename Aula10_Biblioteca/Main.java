import java.util.List;
import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("Digite o título:");
        String titulo  = scan.nextLine();
        System.out.println("Digite o nome do autor:");
        String autor = scan.nextLine();
        System.out.println("Digite o ano de publicação:");
        int ano = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o número de páginas:");
        int paginas = scan.nextInt();
        scan.nextLine();
        Livro novoLivro = new Livro();
        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setAnoPublicacao(ano);
        novoLivro.setNumeroPaginas(paginas);
        try {
            biblioteca.adicionarLivro(novoLivro);
            System.out.println("Livro cadastrado com sucesso!");
            imprimeListaLivros();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void imprimeListaLivros() {
        List<Livro> livros = biblioteca.getAcervo();
        System.out.println("Livros do Acervo");
        for (Livro livro : livros) {
            System.out.println(" - Título: " + livro.getTitulo());
            System.out.println(" - Autor: " + livro.getAutor());
            System.out.println(" - Ano de publicação: " + livro.getAnoPublicacao());
            System.out.println(" - Número de Páginas: " + livro.getNumeroPaginas());
        }
    }
    
}
