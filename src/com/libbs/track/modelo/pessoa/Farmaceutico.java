package com.libbs.track.modelo.pessoa;

import java.time.LocalTime;

/**
 * Farmacêutico habilitado com CRF.
 * Herda de Funcionario e adiciona atributos profissionais específicos.
 * A Anvisa exige que inspeções e relatórios sejam assinados por esta classe.
 */
public class Farmaceutico extends Funcionario {

    private String nome;
    private int    registroCRF;
    private String especialidade;
    private int    tempoExperiencia;

    public Farmaceutico(String nome, int registroCRF, String especialidade,
                        int tempoExperiencia, String localTrabalho,
                        LocalTime horarioEntrada, LocalTime horarioSaida, String turno) {
        // Chama o construtor da classe pai (Funcionario)
        super(nome, localTrabalho, horarioEntrada, horarioSaida, turno);
        this.nome             = nome;
        this.registroCRF      = registroCRF;
        this.especialidade    = especialidade;
        this.tempoExperiencia = tempoExperiencia;
    }

    public String getNome()           { return nome; }
    public int    getRegistroCRF()    { return registroCRF; }
    public String getEspecialidade()  { return especialidade; }
    public int    getTempoExperiencia(){ return tempoExperiencia; }

    /**
     * Sobrescreve o método da classe pai — polimorfismo.
     * Um Farmaceutico se descreve de forma diferente de um Funcionario genérico.
     */
    @Override
    public String getDescricaoCargo() {
        return "Farmaceutico: " + nome + " | CRF: " + registroCRF + " | " + especialidade;
    }

    @Override
    public String toString() {
        return "Farmaceutico{nome='" + nome + "', CRF=" + registroCRF + ", especialidade='" + especialidade + "'}";
    }
}