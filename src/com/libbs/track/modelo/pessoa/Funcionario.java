package com.libbs.track.modelo.pessoa;

import java.time.LocalTime;

/**
 * Representa qualquer colaborador da Libbs.
 * Classe pai de Farmaceutico — demonstra herança.
 */
public class Funcionario {

    private String nomeFuncionario;
    private String localTrabalho;
    private LocalTime horarioEntrada;   // LocalTime, não LocalDate
    private LocalTime horarioSaida;     // LocalTime, não LocalDate
    private String turno;               // "MANHA", "TARDE", "NOITE"

    public Funcionario(String nomeFuncionario, String localTrabalho,
                       LocalTime horarioEntrada, LocalTime horarioSaida,
                       String turno) {
        this.nomeFuncionario = nomeFuncionario;
        this.localTrabalho   = localTrabalho;
        this.horarioEntrada  = horarioEntrada;
        this.horarioSaida    = horarioSaida;
        this.turno           = turno;
    }

    public String getNomeFuncionario() { return nomeFuncionario; }
    public String getLocalTrabalho()   { return localTrabalho; }
    public LocalTime getHorarioEntrada(){ return horarioEntrada; }
    public LocalTime getHorarioSaida() { return horarioSaida; }
    public String getTurno()           { return turno; }

    /** Método que pode ser sobrescrito por subclasses — base para polimorfismo. */
    public String getDescricaoCargo() {
        return "Funcionario: " + nomeFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{nome='" + nomeFuncionario + "', local='" + localTrabalho + "', turno='" + turno + "'}";
    }
}