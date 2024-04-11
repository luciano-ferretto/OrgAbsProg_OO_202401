from Veiculo import Veiculo

class Carro(Veiculo):
    def __init__(self, marca, modelo, ano, placa, quantidade_portas):
        super().__init__(marca, modelo, ano, placa)
        self.__quantidade_portas = quantidade_portas

    def get_quantidade_portas(self):
        return self.__quantidade_portas

    def set_quantidade_portas(self, quantidade_portas):
        self.__quantidade_portas = quantidade_portas

    def __str__(self):
        return super().__str__() + f'\nQuantidade de portas: {self.__quantidade_portas}'
