import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Paciente;
import model.Atendimento;

public class SistemaConsultaMedica {
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Realizar Consulta");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Mostrar Paciente");
            System.out.println("6. Apagar Paciente");
            System.out.println("7. Sair");
            System.out.print("Escolha a opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirPaciente(scanner);
                    break;
                case 2:
                    alterarPaciente(scanner);
                    break;
                case 3:
                    realizarConsulta(scanner);
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
                    mostrarPaciente(scanner);
                    break;
                case 6:
                    apagarPaciente(scanner);
                    break;
                case 7:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 7);
    }

    private static void incluirPaciente(Scanner scanner) {
        scanner.nextLine(); 
        System.out.println(" ");
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sobrenome do paciente: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite a data de nascimento (formato yyyy-MM-dd): ");
        String dataNascimentoStr = scanner.next();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        Paciente novoPaciente = new Paciente(nome, sobrenome, dataNascimento);
        listaPacientes.add(novoPaciente);
        System.out.println("Paciente adicionado com sucesso!");
        System.out.println(" ");
    }

    private static void alterarPaciente(Scanner scanner) {
        scanner.nextLine(); 
        System.out.println(" ");
        System.out.print("Digite o nome do paciente que deseja alterar: ");
        String nomePesquisa = scanner.nextLine();

        for (Paciente paciente : listaPacientes) {
            if (paciente.getNome().equalsIgnoreCase(nomePesquisa)) {
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                paciente.setNome(novoNome);
                System.out.println("Paciente alterado com sucesso!");
                System.out.println(" ");
                return;
            }
        }

        System.out.println("Paciente nao encontrado.");
        System.out.println(" ");
    }

    private static void realizarConsulta(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Digite o nome do paciente para a consulta: ");
        String nomePesquisa = scanner.nextLine();

        for (Paciente paciente : listaPacientes) {
            if (paciente.getNome().equalsIgnoreCase(nomePesquisa)) {
                System.out.print("Digite a data da consulta (formato yyyy-MM-dd): ");
                String dataConsultaStr = scanner.next();
                LocalDate dataConsulta = LocalDate.parse(dataConsultaStr);
                scanner.nextLine();
                System.out.print("Digite a descricao da consulta: ");
                String descricaoConsulta = scanner.nextLine();

                Atendimento novaConsulta = new Atendimento(dataConsulta, descricaoConsulta);
                paciente.adicionarConsulta(novaConsulta);
                System.out.println("Consulta registrada com sucesso!");
                System.out.println(" ");
                return;
            }
        }

        System.out.println("Paciente nao encontrado.");
        System.out.println(" ");
    }

    private static void listarPacientes() {
        for (Paciente paciente : listaPacientes) {
            System.out.println("Nome: " + paciente.getNome() +
                    " | Data de Nascimento: " + paciente.getDataNascimento());
        }
        System.out.println(" ");
    }

    private static void mostrarPaciente(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Digite o nome do paciente para mostrar detalhes: ");
        String nomePesquisa = scanner.nextLine();

        for (Paciente paciente : listaPacientes) {
            if (paciente.getNome().equalsIgnoreCase(nomePesquisa)) {
                System.out.println(paciente);

                System.out.println("Atendimentos:");
                int count = 0;
                for (Atendimento consulta : paciente.getAtendimentos()) {
                    System.out.println(consulta);
                    System.out.println(" ");
                    count++;
                    if (count % 5 == 0) {
                        System.out.print("Pressione Enter para continuar...");
                        System.out.println(" ");
                        scanner.nextLine();
                    }
                }
                System.out.println(" ");
                return;
            }
        }

        System.out.println("Paciente nao encontrado.");
        System.out.println(" ");
    }

    private static void apagarPaciente(Scanner scanner) {
        scanner.nextLine();
        System.out.println(" ");
        System.out.print("Digite o nome do paciente para apagar: ");
        String nomePesquisa = scanner.nextLine();

        Iterator<Paciente> iterator = listaPacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getNome().equalsIgnoreCase(nomePesquisa)) {
                iterator.remove();
                System.out.println("Paciente removido com sucesso!");
                System.out.println(" ");
                return;
            }
        }

        System.out.println("Paciente não encontrado.");
        System.out.println(" ");
    }
}