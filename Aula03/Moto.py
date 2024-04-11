from Veiculo import Veiculo
class Moto(Veiculo):
    def __init__(self, marca, modelo, ano, placa, cilindradas):
        super().__init__(marca, modelo, ano, placa)
        self.__cilindradas = cilindradas

    def get_cilindradas(self):
        return self.__cilindradas

    def set_cilindradas(self, cilindradas):
        self.__cilindradas = cilindradas

    def __str__(self):
        return super().__str__() + f'\nCilindradas: {self.__cilindradas}'
