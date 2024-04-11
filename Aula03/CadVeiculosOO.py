from Caminhao import Caminhao
from Carro import Carro
from Moto import Moto
from Veiculo import Veiculo

def cadastrar():
    print("Escolha o tipo de veículo a cadastrar:")
    print("1 - Carro")
    print("2 - Moto")
    print("3 - Caminhão")
    tipo = input()

    print ("Digite a marca do veículo: ")
    marca = input()
    print ("Digite o modelo do veículo: ")
    modelo = input()
    print ("Digite o ano do veículo: ")
    ano = input()
    print ("Digite a placa do veículo: ")
    placa = input()
    
    if tipo == "1":
        print("Digite a quantidade de portas do carro:")
        quantidade_portas = input()
        veiculo = Carro(marca, modelo, ano, placa, quantidade_portas)
    elif tipo == "2":
        print("Digite as cilindradas da moto:")
        cilindradas = input()
        veiculo = Moto(marca, modelo, ano, placa, cilindradas)
    elif tipo == "3":
        print("Digite a carga máxima do caminhão:")
        carga_maxima = input()
        veiculo = Caminhao(marca, modelo, ano, placa, carga_maxima)
    else:
        print("Opção inválida!")
        return
    
    listaVeiculo.append(veiculo)
    print("Veículo cadastrado com sucesso!")

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
    