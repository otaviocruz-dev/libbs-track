package com.libbs.track.modelo.regulatorio;

import com.libbs.track.modelo.pessoa.Farmaceutico;
import com.libbs.track.modelo.produto.Lote;

import java.time.LocalDate;

public class InspecaoDeQualidade {
    private Lote loteInspecionado;
    private Farmaceutico farmaceuticoResponsavel;
    private LocalDate dataInspecao;
    private String resultado;
    private String observacoes;

    public Lote getLoteInspecionado() {
        return loteInspecionado;
    }

    public void setLoteInspecionado(Lote loteInspecionado) {
        this.loteInspecionado = loteInspecionado;
    }

    public Farmaceutico getFarmaceuticoResponsavel() {
        return farmaceuticoResponsavel;
    }

    public void setFarmaceuticoResponsavel(Farmaceutico farmaceuticoResponsavel) {
        this.farmaceuticoResponsavel = farmaceuticoResponsavel;
    }

    public LocalDate getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(LocalDate dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
