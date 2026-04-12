package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControleDePrazo {

    private Lote loteMonitorado;
    private int limiteAlertaDias;
    private int diasParaVencer;
    private String statusPrazo;

    public ControleDePrazo(Lote loteMonitorado, int limiteAlertaDias) {
        this.loteMonitorado = loteMonitorado;
        this.limiteAlertaDias = limiteAlertaDias;
        calcularStatus();
    }

    public void calcularStatus() {
        diasParaVencer = (int) ChronoUnit.DAYS.between(
                LocalDate.now(), loteMonitorado.getDataValidade());

        if (diasParaVencer <= 0) statusPrazo = "VENCIDO";
        else if (diasParaVencer <= limiteAlertaDias) statusPrazo = "ALERTA";
        else statusPrazo = "OK";
    }

    public String getStatusPrazo() { return statusPrazo; }
    public int getDiasParaVencer() { return diasParaVencer; }
}