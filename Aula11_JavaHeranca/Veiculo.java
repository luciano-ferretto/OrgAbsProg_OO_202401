import java.time.Year;

class Veiculo {
    String marca;
    String modelo;
    int ano;

    public Veiculo(){
        this("","",1900);
    }
    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
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
    
    void ligar() {
        System.out.println("Veículo Ligado!");
    }
}
