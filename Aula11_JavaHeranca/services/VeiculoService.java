package services;

import java.util.ArrayList;
import java.util.List;

import entities.Veiculo;

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
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty())
            throw new Exception("Campo Marca não pode ser em branco");

        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty())
            throw new Exception("Campo Modelo não pode ser em branco");
        veiculosDB.add(veiculo);
        return veiculo;
    }

    public Veiculo findByPlaca(String placa) throws Exception {
        Veiculo veiculoRet = null;
        for (Veiculo veiculo : veiculosDB) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculoRet = veiculo;
                break;
            }
        }
        if (veiculoRet == null)
            throw new Exception("Veículo não encontrado com a placa informada");
        return veiculoRet;
    }

    public void removeByPlaca(String placa) throws Exception {
        Veiculo veiculoRemove = findByPlaca(placa);
        veiculosDB.remove(veiculoRemove);
    }
}
