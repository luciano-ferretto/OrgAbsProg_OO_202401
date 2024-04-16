
from Funcionario import Funcionario

class Vendedor(Funcionario):
    def __init__(self, nome, salario, numero_vendas):
        super().__init__(nome, salario)
        self.__numero_vendas = numero_vendas

    def get_numero_vendas(self):
        return self.__numero_vendas
    
    def set_numero_vendas(self, numero_vendas):
        self.__numero_vendas = numero_vendas

    ##Sobrescrita do método calcular_bonus()
    def calcular_bonus(self):
        return self.get_salario() * 0.10