package controller;

import model.Consulta;
import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ConsultaController {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();

    public void cadastrarPaciente(String nome, String telefone) {
        Paciente paciente = new Paciente(nome, telefone);
        pacientes.add(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void agendarConsulta(Paciente paciente, String dia, String hora, String especialidade) {
        Consulta consulta = new Consulta(paciente, dia, hora, especialidade);
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void cancelarConsulta(int index) {
        if (index >= 0 && index < consultas.size()) {
            consultas.remove(index);
        }
    }
}
