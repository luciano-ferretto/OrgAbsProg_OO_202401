class Veiculo:
    def __init__(self, _marca, _modelo, _ano, _placa):
        self.marca = _marca
        self.modelo = _modelo
        self.ano = _ano
        self.placa = _placa
        
    def calcularTempoUso(self):
        return 2024 - self.ano
    
    def __str__(self):
        return f'''Marca: {self.marca}
Modelo: {self.modelo}
Placa: {self.placa}
Ano: {self.ano}'''
    
# Instanciar um novo objeto da classe Veiculo
#meuVeiculo = Veiculo("Fiat","Uno",2000,"abc-1234")
#teuVeiculo = Veiculo("Volks","Fusca",1995,"def-5678")

#print(meuVeiculo)

#print(f"Marca: {meuVeiculo.marca}")
#print(f"Marca: {teuVeiculo.marca}")

#print(meuVeiculo.calcularTempoUso())
#print(teuVeiculo.calcularTempoUso())

#print ("teste")