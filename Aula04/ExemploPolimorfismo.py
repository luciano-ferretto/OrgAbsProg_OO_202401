class Pessoa:
    def __init__(self, nome):
        self.nome = nome

    def calcular_vendas(self):
        # Método padrão que pode ser sobrescrito nas subclasses
        return 0

class Vendedor(Pessoa):
    def calcular_vendas(self):
        # Implementação específica para o vendedor
        valor_unitario = 10
        produtos_vendidos = 1500
        return valor_unitario * produtos_vendidos


class Diretor(Pessoa):
    def calcular_vendas(self):
        # Implementação específica para o diretor
        valor_unitario = 10
        produtos_vendidos = 1500
        comissao = (valor_unitario * produtos_vendidos) * 10 / 100
        return (valor_unitario * produtos_vendidos) + comissao


# Exemplo de uso
vendedor1 = Vendedor("João")
diretor1 = Diretor("Maria")

print(f"Vendas do {vendedor1.nome}: R${vendedor1.calcular_vendas()}")  # Saída: Vendas do João: R$15000
print(f"Vendas do {diretor1.nome}: R${diretor1.calcular_vendas()}")    # Saída: Vendas do Maria: R$16500
