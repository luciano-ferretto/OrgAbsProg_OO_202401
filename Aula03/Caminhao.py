from Veiculo import Veiculo


class Caminhao(Veiculo):
    def __init__(self, marca, modelo, ano, placa, carga_maxima):
        super().__init__(marca, modelo, ano, placa)
        self.__carga_maxima = carga_maxima

    def get_carga_maxima(self):
        return self.__carga_maxima

    def set_carga_maxima(self, carga_maxima):
        self.__carga_maxima = carga_maxima

    def __str__(self):
        return super().__str__() + f'\nCarga Máxima: {self.__carga_maxima}'