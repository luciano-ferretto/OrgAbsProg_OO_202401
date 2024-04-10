class Veiculo:
    def __init__(self, marca, modelo, ano, placa):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano
        self.placa = placa
    
    def calcularTempoUso(self):
        return 2024 - self.ano
    
    def __str__(self):
        return (f"{self.marca} \n - {self.modelo}")
    
meuVeiculo = Veiculo("Volkswagem", "Fusca", 1995, "ABC-1234")
teuVeiculo = Veiculo("Fiat", "Uno com Escada", 2003, "DEF-5678")

meuVeiculo.ano = 1995

print(meuVeiculo.calcularTempoUso())
print(teuVeiculo.calcularTempoUso())

class GerenciadorVeiculos:
    def __init__(self):
        self.lista_veiculos = []

    def cadastrar(self):
        print("Digite a marca do veículo: ")
        marca = input()
        print("Digite o modelo do veículo: ")
        modelo = input()
        print("Digite o ano do veículo: ")
        ano = input()
        print("Digite a placa do veículo: ")
        placa = input()
        veiculo = Veiculo(marca, modelo, ano, placa)
        self.lista_veiculos.append(veiculo)

    def listar(self):
        if not self.lista_veiculos:
            print("Nenhum veículo cadastrado.")
        else:
            for veiculo in self.lista_veiculos:
                print(f"Veículo: {veiculo.marca} - {veiculo.modelo}")
                print(f"Ano: {veiculo.ano}")
                print(f"Placa: {veiculo.placa}")
                print(veiculo)
                print('-------------------------------')

    def excluir(self):
        if not self.lista_veiculos:
            print("Nenhum veículo cadastrado para excluir.")
        else:
            self.listar()
            print("Digite a placa do veículo a remover: ")
            placa = input()
            veiculo_encontrado = False
            for veiculo in self.lista_veiculos:
                if veiculo.placa == placa:
                    self.lista_veiculos.remove(veiculo)
                    veiculo_encontrado = True
                    break
            if not veiculo_encontrado:
                print("Nenhum veículo encontrado com a placa fornecida.")

gerenciador = GerenciadorVeiculos()

while True:
    print("Escolha uma das opções abaixo:")
    print("1 - Cadastrar veículo")
    print("2 - Listar Veículos")
    print("3 - Excluir Veículo")
    print("0 - Sair")
    opcao = input("Opção: ")
    try:
        opcao = int(opcao)
    except ValueError:
        print("Opção inválida!")
        continue
    if opcao == 0:
        break
    elif opcao == 1:
        gerenciador.cadastrar()
    elif opcao == 2:
        gerenciador.listar()
    elif opcao == 3:
        gerenciador.excluir()
    else:
        print("Opção inválida!")
