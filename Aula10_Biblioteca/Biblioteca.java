import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> acervo;
    public Biblioteca() {
        acervo = new ArrayList<>();
    }

    public List<Livro> getAcervo(){
        return acervo;
    }

    public List<Livro> getAcervo(String tituloContem){
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().contains(tituloContem))
                livrosEncontrados.add(livro);
        }
        return livrosEncontrados;
    }

    public void adicionarLivro(Livro livro) throws Exception {
        if (livro == null) {
            throw new Exception("Objeto não pode ser nulo");
        }
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
            throw new Exception("O Título é um campo obrigatório");
        if (livro.getAutor() ==  null || livro.getAutor().isEmpty())
            throw new Exception("O Autor é um campo obrigatório");
        
        acervo.add(livro);
    }


}
