package com.libbs.track.modelo.produto;

import java.util.Objects;

/**
 * Entidade central do sistema — representa um medicamento fabricado ou
 * distribuído pela Libbs. Tudo no sistema (lotes, inspeções, relatórios)
 * se refere a um Medicamento.
 */
public class Medicamento {

    private final String principioAtivo;
    private String nomeComercial;
    private final String concentracao;
    private final String formaFarmaceutica;
    private String registroAnvisa;

    public Medicamento(String principioAtivo, String nomeComercial,
                       String concentracao, String formaFarmaceutica,
                       String registroAnvisa) {
        this.principioAtivo    = principioAtivo;
        this.nomeComercial     = nomeComercial;
        this.concentracao      = concentracao;
        this.formaFarmaceutica = formaFarmaceutica;
        this.registroAnvisa    = registroAnvisa;
    }

    // Getters
    public String getPrincipioAtivo()    { return principioAtivo; }
    public String getNomeComercial()     { return nomeComercial; }
    public String getConcentracao()      { return concentracao; }
    public String getFormaFarmaceutica() { return formaFarmaceutica; }
    public String getRegistroAnvisa()    { return registroAnvisa; }

    // Setters seletivos — nome comercial e registro podem mudar; princípio ativo não
    public void setNomeComercial(String nomeComercial)   { this.nomeComercial = nomeComercial; }
    public void setRegistroAnvisa(String registroAnvisa) { this.registroAnvisa = registroAnvisa; }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nomeComercial='" + nomeComercial + '\'' +
                ", principioAtivo='" + principioAtivo + '\'' +
                ", concentracao='" + concentracao + '\'' +
                ", forma='" + formaFarmaceutica + '\'' +
                ", registroAnvisa='" + registroAnvisa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicamento)) return false;
        Medicamento m = (Medicamento) o;
        return Objects.equals(registroAnvisa, m.registroAnvisa);
    }

    @Override
    public int hashCode() { return Objects.hash(registroAnvisa); }
}