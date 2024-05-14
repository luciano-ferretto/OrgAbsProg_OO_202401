import java.time.Year;

class Veiculo {
    String marca;
    String modelo;
    int ano;

    public Veiculo(){
        this("","",1900);
    }

    public Veiculo(String marca, String modelo, int ano) {
        System.out.println("Foi criado uma nova instância do Veiculo");
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    Veiculo criarCopiaAPartirDeMim() {
        Veiculo novo = new Veiculo();
        novo.marca = this.marca;
        novo.modelo = this.modelo;
        novo.ano = this.ano;
        return novo;
    }
    
    Veiculo criarCopiaAPartirDeMimERRADO() {
        return this;
    }
    int calcularTempoDeUso() {
        int anoAtual = Year.now().getValue();
        //int tempoUso = anoAtual - this.ano;
        //return tempoUso;
        return this.calcularTempoDeUso(anoAtual);
    }
    int calcularTempoDeUso(int anoBase) {
        int tempoUso = anoBase - this.ano;
        return tempoUso;
    }

    void ligar() {
        System.out.println("Veículo Ligado!");
    }
}
