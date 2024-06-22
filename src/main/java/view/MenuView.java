package view;

import controller.ConsultaController;
import model.Paciente;
import model.Consulta;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private static ConsultaController consultaController = new ConsultaController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Clínica de Consultas Ágil");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Marcar consulta");
            System.out.println("3. Cancelar consulta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner);
                    break;
                case 2:
                    marcarConsulta(scanner);
                    break;
                case 3:
                    cancelarConsulta(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void cadastrarPaciente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        consultaController.cadastrarPaciente(nome, telefone);
    }

    private static void marcarConsulta(Scanner scanner) {
        List<Paciente> pacientes = consultaController.getPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado");
            return;
        }
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }
        System.out.print("Escolha um paciente: ");
        int pacienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nova linha

        if (pacienteIndex < 0 || pacienteIndex >= pacientes.size()) {
            System.out.println("Paciente inválido");
            return;
        }
        Paciente paciente = pacientes.get(pacienteIndex);

        System.out.print("Dia: ");
        String dia = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        consultaController.agendarConsulta(paciente, dia, hora, especialidade);
    }

    private static void cancelarConsulta(Scanner scanner) {
        List<Consulta> consultas = consultaController.getConsultas();
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada");
            return;
        }
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            System.out.println((i + 1) + ". " + consulta.getPaciente().getNome() + " - " + consulta.getDia() + " " + consulta.getHora());
        }
        System.out.print("Escolha uma consulta para cancelar: ");
        int consultaIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nova linha

        if (consultaIndex < 0 || consultaIndex >= consultas.size()) {
            System.out.println("Consulta inválida");
            return;
        }
        consultaController.cancelarConsulta(consultaIndex);
    }
}
