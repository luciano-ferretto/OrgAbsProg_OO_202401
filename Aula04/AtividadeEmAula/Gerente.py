
from Funcionario import Funcionario

class Gerente(Funcionario):
    def __init__(self, nome, salario):
        super().__init__(nome, salario)

    def calcular_bonus(self):
        return self.get_salario() * 0.15