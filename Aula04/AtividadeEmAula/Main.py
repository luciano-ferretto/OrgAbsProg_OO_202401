from Gerente import Gerente
from Vendedor import Vendedor

vendedor_online = Vendedor("Luciano", 1850, 35)
gerente_vendas = Gerente("Pedro", 12500)
print(f"Bonus do Vendedor {vendedor_online.get_nome()}: {vendedor_online.calcular_bonus()}")
print(f"Bonus do Gerente {gerente_vendas.get_nome()}: {gerente_vendas.calcular_bonus()}")
#O Funcionário foi demitido e contratado novo com novo salário
vendedor_online.set_nome("João")
vendedor_online.set_salario(2250)
vendedor_online.set_numero_vendas(0)
print(f"Bonus do novo Vendedor {vendedor_online.get_nome()}: {vendedor_online.calcular_bonus()}")


