
from Veiculo import Veiculo

class Carro(Veiculo):
    def __init__(self, marca, modelo, ano, placa, numeroPortas):
        super().__init__(marca, modelo, ano, placa)
        self.numeroPortas = numeroPortas
    
    def __str__(self):
        return super().__str__() + f"\nNúmero de Portas: {self.numeroPortas}"
