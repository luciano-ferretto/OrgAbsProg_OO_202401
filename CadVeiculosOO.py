
from Veiculo import Veiculo
def cadastrar():
    print ("Digite a marca do veículo: ")
    marca = input()
    print ("Digite o modelo do veículo: ")
    modelo = input()
    print ("Digite o ano do veículo: ")
    ano = input()
    print ("Digite a placa do veículo: ")
    placa = input()
    veiculo = Veiculo(marca,modelo,ano,placa)
    listaVeiculo.append(veiculo)

def listar():
    if not listaVeiculo:
        print ("Não há veículos cadastrados")
    else:
        for veiculo in listaVeiculo:
            print(veiculo)
            print('-------------------------------')

def excluir():
    if not listaVeiculo:
        print ("Não há veículos cadastrados")
    else:
        listar()
        print ("Digite a placa do veículo a remover: ")
        placa = input()
        encontrouVeiculo = False
        for veiculo in listaVeiculo:
            if veiculo.placa == placa:
                listaVeiculo.remove(veiculo)
                encontrouVeiculo =True
                break
        if not encontrouVeiculo:
            print("Veículo não encontrado")

#Lista de veículos cadastrados - BD em memória
listaVeiculo = []

#opcao = -1
while True:    
    print ("Escolha uma das opções abaixo:")
    print ("1 - Cadastrar veículo")
    print ("2 - Listar Veículos")
    print ("3 - Excluir Veículo")
    print ("0 - Sair")
    opcao = input()
    try:
        opcao = int(opcao)
    except:
        print("Opção inválida!")
    if opcao == 0: 
        break
    elif opcao == 1:
        cadastrar()
    elif opcao == 2:
        listar()
    elif opcao == 3:
        excluir()
    else:
        print("Opção inválida!")
    