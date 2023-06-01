package projetofinaljogobingo;
import java.util.List;

import java.util.Scanner;
public class JogoBingo {
    public static void main(String[] args) {
        GestorClientes gestorClientes = new GestorClientes();
        GestorVendas gestorVendas = new GestorVendas();
        GestorRodadas gestorRodadas = new GestorRodadas();
        GestorFinanceiro gestorFinanceiro = new GestorFinanceiro();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== MENU ======");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Vendas");
            System.out.println("3. Gestão de Rodadas");
            System.out.println("4. Gestão Financeira");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("====== GESTÃO DE CLIENTES ======");
                    System.out.println("1. Cadastrar Cliente");
                    System.out.println("2. Editar Cliente");
                    System.out.println("3. Deletar Cliente");
                    System.out.println("4. Listar Clientes");
                    System.out.print("Escolha uma opção: ");
                    int opcaoClientes = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoClientes) {
                        case 1:
                            System.out.println("====== CADASTRAR CLIENTE ======");
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Endereço: ");
                            String endereco = scanner.nextLine();
                            System.out.print("Telefone: ");
                            String telefone = scanner.nextLine();
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            Cliente cliente = new Cliente(nome, endereco, telefone, email);
                            gestorClientes.cadastrarCliente(cliente);
                            System.out.println("Cliente cadastrado com sucesso!");
                            break;
                        case 2:
                            System.out.println("====== EDITAR CLIENTE ======");
                            List<Cliente> clientes = gestorClientes.listarClientes();
                            if (!clientes.isEmpty()) {
                                for (int i = 0; i < clientes.size(); i++) {
                                    System.out.println(i + ". " + clientes.get(i).getNome());
                                }
                                System.out.print("Digite o número do cliente que deseja editar: ");
                                int numeroClienteEditar = scanner.nextInt();
                                scanner.nextLine();
                                if (numeroClienteEditar >= 0 && numeroClienteEditar < clientes.size()) {
                                    Cliente clienteEditar = clientes.get(numeroClienteEditar);
                                    System.out.print("Novo nome: ");
                                    clienteEditar.setNome(scanner.nextLine());
                                    System.out.print("Novo endereço: ");
                                    clienteEditar.setEndereco(scanner.nextLine());
                                    System.out.print("Novo telefone: ");
                                    clienteEditar.setTelefone(scanner.nextLine());
                                    System.out.print("Novo email: ");
                                    clienteEditar.setEmail(scanner.nextLine());
                                    gestorClientes.editarCliente(numeroClienteEditar, clienteEditar);
                                    System.out.println("Cliente editado com sucesso!");
                                } else {
                                    System.out.println("Número de cliente inválido!");
                                }
                            } else {
                                System.out.println("Não há clientes cadastrados!");
                            }
                            break;
                        case 3:
                            System.out.println("====== DELETAR CLIENTE ======");
                            List<Cliente> clientesExcluir = gestorClientes.listarClientes();
                            if (!clientesExcluir.isEmpty()) {
                                for (int i = 0; i < clientesExcluir.size(); i++) {
                                    System.out.println(i + ". " + clientesExcluir.get(i).getNome());
                                }
                                System.out.print("Digite o número do cliente que deseja excluir: ");
                                int numeroClienteExcluir = scanner.nextInt();
                                scanner.nextLine();
                                if (numeroClienteExcluir >= 0 && numeroClienteExcluir < clientesExcluir.size()) {
                                    gestorClientes.deletarCliente(numeroClienteExcluir);
                                    System.out.println("Cliente excluído com sucesso!");
                                } else {
                                    System.out.println("Número de cliente inválido!");
                                }
                            } else {
                                System.out.println("Não há clientes cadastrados!");
                            }
                            break;
                        case 4:
                            System.out.println("====== LISTAR CLIENTES ======");
                            List<Cliente> clientesListar = gestorClientes.listarClientes();
                            if (!clientesListar.isEmpty()) {
                                for (Cliente cliente1 : clientesListar) {
                                    System.out.println("Nome: " + cliente1.getNome());
                                    System.out.println("Endereço: " + cliente1.getEndereco());
                                    System.out.println("Telefone: " + cliente1.getTelefone());
                                    System.out.println("Email: " + cliente1.getEmail());
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Não há clientes cadastrados!");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    System.out.println("====== GESTÃO DE VENDAS ======");
                    System.out.println("1. Cadastrar Cartela");
                    System.out.println("2. Vender Cartela");
                    System.out.println("3. Listar Cartelas Disponíveis");
                    System.out.println("4. Listar Cartelas Vendidas");
                    System.out.print("Escolha uma opção: ");
                    int opcaoVendas = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoVendas) {
                        case 1:
                            System.out.println("====== CADASTRAR CARTELA ======");
                            System.out.print("Número da Cartela: ");
                            int numeroCartela = scanner.nextInt();
                            System.out.print("Valor da Cartela: ");
                            double valorCartela = scanner.nextDouble();
                            Cartela cartela = new Cartela(numeroCartela, valorCartela);
                            cartela.gerarNumerosAleatorios();
                            gestorVendas.cadastrarCartela(cartela);
                            System.out.println("Cartela cadastrada com sucesso!");
                            break;
                        case 2:
                            System.out.println("====== VENDER CARTELA ======");
                            List<Cartela> cartelasDisponiveisVenda = gestorVendas.listarCartelasDisponiveis();
                            if (!cartelasDisponiveisVenda.isEmpty()) {
                                for (int i = 0; i < cartelasDisponiveisVenda.size(); i++) {
                                    System.out.println(i + ". Número da Cartela: " + cartelasDisponiveisVenda.get(i).getNumero());
                                }
                                System.out.print("Digite o número da cartela que deseja vender: ");
                                int numeroCartelaVenda = scanner.nextInt();
                                scanner.nextLine();
                                if (numeroCartelaVenda >= 0 && numeroCartelaVenda < cartelasDisponiveisVenda.size()) {
                                    gestorVendas.venderCartela(numeroCartelaVenda);
                                    System.out.println("Cartela vendida com sucesso!");
                                } else {
                                    System.out.println("Número de cartela inválido!");
                                }
                            } else {
                                System.out.println("Não há cartelas disponíveis para venda!");
                            }
                            break;
                        case 3:
                            System.out.println("====== LISTAR CARTELAS DISPONÍVEIS ======");
                            List<Cartela> cartelasDisponiveisListar = gestorVendas.listarCartelasDisponiveis();
                            if (!cartelasDisponiveisListar.isEmpty()) {
                                for (Cartela cartelaDisponivel : cartelasDisponiveisListar) {
                                    System.out.println("Número da Cartela: " + cartelaDisponivel.getNumero());
                                    System.out.println("Valor da Cartela: " + cartelaDisponivel.getValor());
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Não há cartelas disponíveis!");
                            }
                            break;
                        case 4:
                            System.out.println("====== LISTAR CARTELAS VENDIDAS ======");
                            List<Cartela> cartelasVendidasListar = gestorVendas.listarCartelasVendidas();
                            if (!cartelasVendidasListar.isEmpty()) {
                                for (Cartela cartelaVendida : cartelasVendidasListar) {
                                    System.out.println("Número da Cartela: " + cartelaVendida.getNumero());
                                    System.out.println("Valor da Cartela: " + cartelaVendida.getValor());
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Não há cartelas vendidas!");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    System.out.println("====== GESTÃO DE RODADAS ======");
                    System.out.println("1. Criar Rodada");
                    System.out.println("2. Sortear Número");
                    System.out.println("3. Listar Rodadas");
                    System.out.print("Escolha uma opção: ");
                    int opcaoRodadas = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoRodadas) {
                        case 1:
                            System.out.println("====== CRIAR RODADA ======");
                            gestorRodadas.criarRodada();
                            System.out.println("Rodada criada com sucesso!");
                            break;
                        case 2:
                            System.out.println("====== SORTEAR NÚMERO ======");
                            List<Rodada> rodadasListar = gestorRodadas.listarRodadas();
                            if (!rodadasListar.isEmpty()) {
                                for (int i = 0; i < rodadasListar.size(); i++) {
                                    System.out.println(i + ". Número da Rodada: " + rodadasListar.get(i).getNumero());
                                }
                                System.out.print("Digite o número da rodada em que deseja sortear um número: ");
                                int numeroRodadaSorteio = scanner.nextInt();
                                scanner.nextLine();
                                if (numeroRodadaSorteio >= 0 && numeroRodadaSorteio < rodadasListar.size()) {
                                    gestorRodadas.sortearNumero(numeroRodadaSorteio);
                                } else {
                                    System.out.println("Número de rodada inválido!");
                                }
                            } else {
                                System.out.println("Não há rodadas criadas!");
                            }
                            break;
                        case 3:
                            System.out.println("====== LISTAR RODADAS ======");
                            List<Rodada> rodadasListarTodas = gestorRodadas.listarRodadas();
                            if (!rodadasListarTodas.isEmpty()) {
                                for (Rodada rodada : rodadasListarTodas) {
                                    System.out.println("Número da Rodada: " + rodada.getNumero());
                                    System.out.println("Números Sorteados: " + rodada.getNumerosSorteados());
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Não há rodadas criadas!");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 4:
                    System.out.println("====== GESTÃO FINANCEIRA ======");
                    System.out.println("1. Registrar Receita");
                    System.out.println("2. Registrar Despesa");
                    System.out.println("3. Calcular Total de Receitas");
                    System.out.println("4. Calcular Total de Despesas");
                    System.out.println("5. Calcular Lucro");
                    System.out.print("Escolha uma opção: ");
                    int opcaoFinanceiro = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoFinanceiro) {
                        case 1:
                            System.out.println("====== REGISTRAR RECEITA ======");
                            System.out.print("Valor da Receita: ");
                            double valorReceita = scanner.nextDouble();
                            gestorFinanceiro.registrarReceita(valorReceita);
                            System.out.println("Receita registrada com sucesso!");
                            break;
                        case 2:
                            System.out.println("====== REGISTRAR DESPESA ======");
                            System.out.print("Valor da Despesa: ");
                            double valorDespesa = scanner.nextDouble();
                            gestorFinanceiro.registrarDespesa(valorDespesa);
                            System.out.println("Despesa registrada com sucesso!");
                            break;
                        case 3:
                            System.out.println("====== CALCULAR TOTAL DE RECEITAS ======");
                            double totalReceitas = gestorFinanceiro.calcularTotalReceitas();
                            System.out.println("Total de Receitas: " + totalReceitas);
                            break;
                        case 4:
                            System.out.println("====== CALCULAR TOTAL DE DESPESAS ======");
                            double totalDespesas = gestorFinanceiro.calcularTotalDespesas();
                            System.out.println("Total de Despesas: " + totalDespesas);
                            break;
                        case 5:
                            System.out.println("====== CALCULAR LUCRO ======");
                            double lucro = gestorFinanceiro.calcularLucro();
                            System.out.println("Lucro: " + lucro);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

}
