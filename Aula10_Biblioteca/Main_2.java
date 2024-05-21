public class Main_2 {
    public static void main(String[] args) {
		String nome = "João";
        Pessoa pessoa = new Pessoa("João");

		System.out.println("Nome do Objeto: " + pessoa.nome + " + Nome na String: " + nome);
        transformarMaiuscula(pessoa, nome);
        System.out.println("Nome do Objeto: " + pessoa.nome + " + Nome na String: " + nome);
    }

    public static void transformarMaiuscula(Pessoa pessoaMetodo, String nomeMetodo) {
		nomeMetodo = nomeMetodo.toUpperCase();
        pessoaMetodo.nome = pessoaMetodo.nome.toUpperCase(); 
    }
}

// Classe Pessoa
class Pessoa {
    public String nome;
    public Pessoa(String nome) {
        this.nome = nome;
    }
}




