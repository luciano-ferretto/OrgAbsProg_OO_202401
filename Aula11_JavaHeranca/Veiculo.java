import java.time.Year;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    //sobrescrever nas classes filhas
    public abstract double calcularImposto();

    @Override
    public String toString() {
        return "Veículo: " + this.getMarca()
            + " " + this.getModelo()
            + " " + this.getAno();
    }

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
    
    //Métodos Getters and Setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    void ligar() {
        System.out.println("Veículo Ligado!");
    }
}
