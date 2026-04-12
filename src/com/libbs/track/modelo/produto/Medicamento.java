package com.libbs.track.modelo.produto;

public class Medicamento {

    private String principioAtivo;
    private String nomeComercial;
    private String concentracao;
    private String formaFarmaceutica;
    private String registroAnvisa;

    public Medicamento(String principioAtivo, String nomeComercial,
                       String concentracao, String formaFarmaceutica,
                       String registroAnvisa) {
        this.principioAtivo = principioAtivo;
        this.nomeComercial = nomeComercial;
        this.concentracao = concentracao;
        this.formaFarmaceutica = formaFarmaceutica;
        this.registroAnvisa = registroAnvisa;
    }
}