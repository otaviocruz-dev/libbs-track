package com.libbs.track.modelo.logistica;

/**
 * Empresa responsável por receber lotes da Libbs e distribuí-los
 * para farmácias, hospitais e postos de saúde.
 */
public class Distribuidor {

    private String nomeDistribuidor;   // ex: "Drogasil", "Ultrafarma"
    private String cnpj;
    private String segmento;          // "FARMACIA", "HOSPITAL", "DISTRIBUIDORA"
    private String cidade;
    private String contatoResponsavel;

    public Distribuidor(String nomeDistribuidor, String cnpj,
                        String segmento, String cidade, String contatoResponsavel) {
        this.nomeDistribuidor   = nomeDistribuidor;
        this.cnpj               = cnpj;
        this.segmento           = segmento;
        this.cidade             = cidade;
        this.contatoResponsavel = contatoResponsavel;
    }

    public String getNomeDistribuidor()   { return nomeDistribuidor; }
    public String getCnpj()               { return cnpj; }
    public String getSegmento()           { return segmento; }
    public String getCidade()             { return cidade; }
    public String getContatoResponsavel() { return contatoResponsavel; }

    @Override
    public String toString() {
        return "Distribuidor{nome='" + nomeDistribuidor + "', segmento='" + segmento + "', cidade='" + cidade + "'}";
    }
}