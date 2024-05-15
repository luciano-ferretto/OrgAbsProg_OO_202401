public class CadVeiculo {
    public static void main(String[] args) {

        //Comparando atribuições de Valor X Referência
        int numero01 = 3;
        int numero02 = numero01;
        numero02++;
        System.out.println("Número 01: " + numero01);
        System.out.println("Número 02: " + numero02);

        Veiculo veiculo01 = new Veiculo("Fiat", "Uno com escada", 2005);
        Veiculo veiculo02 = veiculo01;
        veiculo02.ano = 2010;
        System.out.println("Ano do veículo 01: " + veiculo01.ano);
        System.out.println("Ano do veículo 02: " + veiculo02.ano);


        
        // Veiculo meuVeiculo = new Veiculo();
        // meuVeiculo.marca = "Fiat";
        // meuVeiculo.modelo = "Uno";
        // meuVeiculo.ano = 2003;
        Veiculo meuVeiculo = new Veiculo("Fiat", "Uno", 2003);

        Veiculo meuVeiculo3 = meuVeiculo.criarCopiaAPartirDeMim();
        meuVeiculo3.ano = 2010;

        Veiculo teuVeiculo = new Veiculo();
        teuVeiculo.marca = "Volkswagen";
        teuVeiculo.modelo = "Fusca";
        teuVeiculo.ano = 1995;

        int tempoUsoMeuVeiculo = meuVeiculo.calcularTempoDeUso();
        System.out.println("O Tempo de uso do Meu Veículo é: " + tempoUsoMeuVeiculo);
        System.out.println("O Tempo de uso do Teu Veículo é: " + teuVeiculo.calcularTempoDeUso());

        System.out.println("Em 2030 Meu Veículo terá :" + meuVeiculo.calcularTempoDeUso(2030));

        // Na linha abaixo NÃO estamos criando um novo objeto
        // Apenas estamos declarando uma nova variável do tipo "Veiculo"
        // E referenciando ela ao MESMO objeto a qual a variavel "meuVeiculo" já
        // referenciava
        // Ou seja, ambas, "meuVeiculo" e "meuVeiculo2" estão referenciando o MESMO
        // objetos
        Veiculo meuVeiculo2 = meuVeiculo;
        meuVeiculo2.ano = 2005;

    }
}
