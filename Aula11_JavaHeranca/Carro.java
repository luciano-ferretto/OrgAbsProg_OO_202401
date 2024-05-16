public class Carro extends Veiculo {
    private int numeroPortas;
    
    @Override
    public double calcularImposto() {
        return 1000.0;
    }
    @Override
    public String toString() {
        return super.toString()
            + " - N. Portas: " + this.getNumeroPortas();
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }
    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
    public Carro(String marca, String modelo, int ano, int numeroPortas) {
        super(marca, modelo, ano);
        this.numeroPortas = numeroPortas;
    }
    
    
}
