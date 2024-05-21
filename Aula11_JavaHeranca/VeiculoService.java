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
    
    public Veiculo save(Veiculo veiculo) throws Exception {
        if (veiculo == null)
            throw new Exception("Objeto nullo");
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty())
            throw new Exception("Campo Modelo não pode ser em branco");
        veiculosDB.add(veiculo);
        return veiculo;
    }
}
