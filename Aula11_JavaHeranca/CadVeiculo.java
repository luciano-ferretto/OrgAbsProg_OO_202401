import java.util.List;
import java.util.Scanner;

import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import services.VeiculoService;

public class CadVeiculo {
    private static Scanner scan;
    private static VeiculoService veiculoService;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        veiculoService = new VeiculoService();
        int opcao;
        do {
            System.out.print("\033[H\033[2J");
            System.out.println("Sistema de Gerenciamento de Frotas");
            System.out.println("MENU DE OPÇÕES:");
            System.out.println("1 - Cadastrar Novo Veículo");
            System.out.println("2 - Listar todos os Veículos");
            System.out.println("3 - Pesquisar Veículo por Placa");
            System.out.println("4 - Remover Veículo");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            do {
                if (scan.hasNextInt()) {
                    opcao = scan.nextInt();
                    if (opcao >= 0 && opcao <= 4)
                        break;
                }
                scan.nextLine(); //para limpar buffer do scan
                System.out.print("Digite um número dentro das Opções acima: ");
            } while (true);
            scan.nextLine();
            System.out.print("\033[H\033[2J");
            switch (opcao) {
                case 1:
                    save();
                    System.out.println("Pressione Enter para voltar ao Menu Incial");
                    scan.nextLine();
                    break;
                case 2:
                    imprimirVeiculos();
                    System.out.println("Pressione Enter para voltar ao Menu Incial");
                    scan.nextLine();
                    break;
                case 3:
                    findByPlaca();
                    System.out.println("Pressione Enter para voltar ao Menu Incial");
                    scan.nextLine();
                    break;
                case 4:
                    remove();
                    System.out.println("Pressione Enter para voltar ao Menu Incial");
                    scan.nextLine();
                    break;
                case 0:
                    System.out.println("Volte logo!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void save() {
        Veiculo veiculoAdd;
        System.out.print("\033[H\033[2J");
        System.out.println("CADASTRO DE VEÍCULO");
        System.out.println("Qual o tipo de veículo");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.print("Digite a opção desejada: ");
        int tipoVeiculo;
        do {
            if (scan.hasNextInt()){
                tipoVeiculo = scan.nextInt();
                if (tipoVeiculo >= 1 && tipoVeiculo <= 2)
                    break;
            }
            scan.nextLine();
            System.out.print("Digite um número dentro das Opções acima: ");
        } while (true);
        scan.nextLine();
        String descricao = tipoVeiculo == 1 ? "do carro: " : "da moto: ";

        System.out.print("Digite a marca " + descricao);
        String marca = scan.nextLine();
        System.out.print("Digite o modelo " + descricao);
        String modelo = scan.nextLine();
        System.out.print("Digite o ano " + descricao);
        int ano;
        do {
            if (scan.hasNextInt()){
                ano = scan.nextInt();
                break;
            }
            scan.nextLine();
            System.out.print("Digite um ano válido: ");
        } while (true);
        scan.nextLine();
        System.out.print("Digite a placa " + descricao);
        String placa = scan.nextLine();

        if (tipoVeiculo == 1) {
            System.out.print("Digite o número de portas: ");
            int numeroPortas;
            do {
                if (scan.hasNextInt()){
                    numeroPortas = scan.nextInt();
                    if (numeroPortas >= 2 && numeroPortas <= 4)
                        break;
                }
                scan.nextLine();
                System.out.print("Digite o número de portas válido: ");
            } while (true);
            scan.nextLine();
            veiculoAdd = new Carro(marca, modelo, ano, placa, numeroPortas);
        } else {
            System.out.print("A moto possui partida elétrica: 1-Sim, 2-Não: ");
            int partidaEletrica;
            do {
                if (scan.hasNextInt()){
                    partidaEletrica = scan.nextInt();
                    if (partidaEletrica == 1 || partidaEletrica == 2)
                        break;
                }
                scan.nextLine();
                System.out.print("Digite um número dentro das Opções acima: ");
            } while (true);
            scan.nextLine();
            boolean partida = partidaEletrica == 1 ? true : false;
            veiculoAdd = new Moto(marca, modelo, ano, placa, partida);
        }
        try {
            veiculoService.save(veiculoAdd);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO");
            System.out.println(e.getMessage());
        }
    }

    private static void imprimirVeiculos() {
        List<Veiculo> veiculos = veiculoService.getVeiculosDB();

        
        System.out.println("LISTA DE VEÍCULOS CADASTRADOS");
        int i = 1;
        for (Veiculo veiculo : veiculos) {
            String tipo = veiculo instanceof Carro ? "Carro" : "Moto";
            System.out.print("Veículo " + i++ + " - Tipo: " + tipo);
            System.out.println(" - " + veiculo);
        }
    }
 
    private static void findByPlaca() {
        System.out.print("\033[H\033[2J");
        System.out.println("PESQUISA DE VEÍCULOS POR PLACA");
        System.out.print("Informe a placa que deseja pesquisar: ");
        String placa = scan.nextLine();
        try {
            Veiculo veiculo = veiculoService.findByPlaca(placa);
            String tipo = veiculo instanceof Carro ? "Carro" : "Moto";
            System.out.print("Veículo Tipo: " + tipo);
            System.out.println(" - " + veiculo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    private static void remove() {
        System.out.print("\033[H\033[2J");
        System.out.println("REMOÇÃO DE VEÍCULOS");

        imprimirVeiculos();
        System.out.print("Informe a placa do veículo que deseja REMOVER: ");
        String placa = scan.nextLine();
        try {
            veiculoService.removeByPlaca(placa);
            System.out.println("Veículo removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
