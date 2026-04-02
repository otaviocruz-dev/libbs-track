package com.libbs.track.modelo.produto;

public class Medicamento {

    private String nomePrincipio;
    private String nomeComercial;
    private String concentracao;
    private String formaFarmaceutica;
    private String numRegistroAnvisa;

    public Medicamento(String nomePrincipio, String nomeComercial, String concentracao, String formaFarmaceutica, String numRegistroAnvisa) {
    }

    public String getNomePrincipio() {
        return nomePrincipio;
    }

    public void setNomePrincipio(String nomePrincipio) {
        this.nomePrincipio = nomePrincipio;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getNumRegistroAnvisa() {
        return numRegistroAnvisa;
    }

    public void setNumRegistroAnvisa(String numRegistroAnvisa) {
        this.numRegistroAnvisa = numRegistroAnvisa;
    }
}
