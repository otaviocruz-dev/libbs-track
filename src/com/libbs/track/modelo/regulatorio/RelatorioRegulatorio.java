package com.libbs.track.modelo.regulatorio;

import com.libbs.track.modelo.pessoa.Farmaceutico;

import java.time.LocalDate;

public class RelatorioRegulatorio {

    private String codigoRelatorio;
    private String tipoRelatorio;
    private LocalDate dataEmissao;
    private Farmaceutico farmaceuticoResponsavel;
    private String conteudo;

    public String getCodigoRelatorio() {
        return codigoRelatorio;
    }

    public void setCodigoRelatorio(String codigoRelatorio) {
        this.codigoRelatorio = codigoRelatorio;
    }

    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(String tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Farmaceutico getFarmaceuticoResponsavel() {
        return farmaceuticoResponsavel;
    }

    public void setFarmaceuticoResponsavel(Farmaceutico farmaceuticoResponsavel) {
        this.farmaceuticoResponsavel = farmaceuticoResponsavel;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
