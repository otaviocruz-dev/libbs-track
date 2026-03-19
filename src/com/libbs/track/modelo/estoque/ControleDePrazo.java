package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDate;

public class ControleDePrazo {

    private Lote loteMonitorado;
    private LocalDate dataValidade;
    private int diasParaVencer;
    private int limiteAlertaDias;
    private String statusPrazo;


    public Lote getLoteMonitorado() {
        return loteMonitorado;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public int getLimiteAlertaDias() {
        return limiteAlertaDias;
    }

    public void setLimiteAlertaDias(int limiteAlertaDias) {
        this.limiteAlertaDias = limiteAlertaDias;
    }

    public String getStatusPrazo() {
        return statusPrazo;
    }


}
