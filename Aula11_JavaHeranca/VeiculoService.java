import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private List<Veiculo> veiculosDB;

    public List<Veiculo> getVeiculosDB() {
        return veiculosDB;
    }

    public VeiculoService() {
        this.veiculosDB = new ArrayList<>();
    }
    
    public Veiculo save(Veiculo veiculo) {
        
        veiculosDB.add(veiculo);
        return veiculo;
    }
}
