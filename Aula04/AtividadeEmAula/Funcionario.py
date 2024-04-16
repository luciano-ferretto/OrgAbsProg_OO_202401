class Funcionario:
    def __init__(self, nome, salario):
        self.__nome = nome
        self.__salario = salario

    def calcular_bonus(self):
        return 0

    def get_nome(self):
        return self.__nome
    
    def set_nome(self, nome):
        self.__nome = nome
    
    def get_salario(self):
        return self.__salario
    
    def set_salario(self, salario):
        self.__salario = salario