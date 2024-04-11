class Veiculo:
    def __init__(self, marca, modelo, ano, placa):
        self.__marca = marca
        self.__modelo = modelo
        self.__ano = ano
        self.__placa = placa
        
    def get_marca(self):
        return self.__marca
    def set_marca(self, marca):
        self.__marca = marca

    def get_modelo(self):
        return self.__modelo
    def set_model(self, modelo):
        self.__modelo = modelo
    
    def get_ano(self):
        return self.__ano
    def set_ano(self, ano):
        self.__ano = ano

    def get_placa(self):
        return self.__placa
    def set_placa(self, placa):
        self.__placa = placa

    def calcularTempoUso(self):
        return 2024 - self.ano
    def __str__(self):
        return f'''Marca: {self.marca}
Modelo: {self.modelo}
placa: {self.placa}
Ano: {self.ano}'''
