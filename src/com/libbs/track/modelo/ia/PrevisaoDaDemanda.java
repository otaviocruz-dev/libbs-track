package com.libbs.track.modelo.ia;

import com.libbs.track.modelo.produto.Medicamento;

import java.time.LocalDate;

public class PrevisaoDaDemanda {
    private Medicamento medicamentoPrevisto;
    private Integer quantidadePrevista;
    private String periodoReferencia;
    private LocalDate dataGeracao;
    private Double acuraciaModelo;

    public Medicamento getMedicamentoPrevisto() {
        return medicamentoPrevisto;
    }

    public void setMedicamentoPrevisto(Medicamento medicamentoPrevisto) {
        this.medicamentoPrevisto = medicamentoPrevisto;
    }

    public Integer getQuantidadePrevista() {
        return quantidadePrevista;
    }

    public void setQuantidadePrevista(Integer quantidadePrevista) {
        this.quantidadePrevista = quantidadePrevista;
    }

    public String getPeriodoReferencia() {
        return periodoReferencia;
    }

    public void setPeriodoReferencia(String periodoReferencia) {
        this.periodoReferencia = periodoReferencia;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Double getAcuraciaModelo() {
        return acuraciaModelo;
    }

    public void setAcuraciaModelo(Double acuraciaModelo) {
        this.acuraciaModelo = acuraciaModelo;
    }
}
