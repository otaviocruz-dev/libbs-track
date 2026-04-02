package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDate;

/**
 * Representa um processo de recolhimento de lotes do mercado.
 * Acionado por desvio de qualidade, contaminação ou determinação da Anvisa.
 */
public class Recall {

    private String    codigoRecall;
    private Lote      loteAfetado;
    private String    motivoRecall;      // ex: "Contaminacao microbiologica"
    private LocalDate dataInicioRecall;
    private String    statusRecall;      // "ABERTO", "EM_ANDAMENTO", "CONCLUIDO"

    public Recall(String codigoRecall, Lote loteAfetado, String motivoRecall,
                  LocalDate dataInicioRecall, String statusRecall) {
        this.codigoRecall    = codigoRecall;
        this.loteAfetado     = loteAfetado;
        this.motivoRecall    = motivoRecall;
        this.dataInicioRecall = dataInicioRecall;
        this.statusRecall    = statusRecall;
    }

    public String    getCodigoRecall()     { return codigoRecall; }
    public Lote      getLoteAfetado()      { return loteAfetado; }
    public String    getMotivoRecall()     { return motivoRecall; }
    public LocalDate getDataInicioRecall() { return dataInicioRecall; }
    public String    getStatusRecall()     { return statusRecall; }

    public void setStatusRecall(String statusRecall) { this.statusRecall = statusRecall; }

    @Override
    public String toString() {
        return "Recall{codigo='" + codigoRecall + "', lote=" + loteAfetado.getCodigoLote() + ", motivo='" + motivoRecall + "', status='" + statusRecall + "'}";
    }
}