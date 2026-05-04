package com.libbs.track.modelo.produto;

/**
 * Medicamento de origem biológica ou biossimilar.
 * A Libbs possui uma divisão de biotecnologia real (ex: Altekin).
 * Herda de Medicamento e adiciona atributos específicos de biológicos,
 * que têm regras de fabricação e armazenamento distintas dos convencionais.
 */
public class Biotecnologia extends Medicamento {

    private String areaAtuacao;         // ex: "Oncologia", "Imunologia"
    private String tecnologiaUtilizada; // ex: "DNA Recombinante", "Anticorpo Monoclonal"
    private String instituicao;         // parceiro de pesquisa, se houver
    private String nivelPesquisa;       // "PESQUISA", "CLINICO", "COMERCIAL"
    private String finalidade;          // ex: "Tratamento de diabetes tipo 2"

    public Biotecnologia(String principioAtivo, String nomeComercial,
                         String concentracao, String formaFarmaceutica,
                         String registroAnvisa, String areaAtuacao,
                         String tecnologiaUtilizada, String instituicao,
                         String nivelPesquisa, String finalidade) {
        // Chama o construtor de Medicamento — herança explícita
        super(principioAtivo, nomeComercial, concentracao, formaFarmaceutica, registroAnvisa);
        this.areaAtuacao          = areaAtuacao;
        this.tecnologiaUtilizada  = tecnologiaUtilizada;
        this.instituicao          = instituicao;
        this.nivelPesquisa        = nivelPesquisa;
        this.finalidade           = finalidade;
    }

    // Getters
    public String getAreaAtuacao()         { return areaAtuacao; }
    public String getTecnologiaUtilizada() { return tecnologiaUtilizada; }
    public String getInstituicao()         { return instituicao; }
    public String getNivelPesquisa()       { return nivelPesquisa; }
    public String getFinalidade()          { return finalidade; }

    // Setters seletivos
    public void setNivelPesquisa(String nivelPesquisa) { this.nivelPesquisa = nivelPesquisa; }
    public void setInstituicao(String instituicao)     { this.instituicao = instituicao; }

    /**
     * Sobrescreve toString para incluir informações do biológico.
     * Polimorfismo: um Biotecnologia se descreve de forma mais detalhada
     * do que um Medicamento genérico.
     */
    @Override
    public String toString() {
        return "Biotecnologia{" +
                "nomeComercial='" + getNomeComercial() + '\'' +
                ", area='" + areaAtuacao + '\'' +
                ", tecnologia='" + tecnologiaUtilizada + '\'' +
                ", nivel='" + nivelPesquisa + '\'' +
                '}';
    }
}