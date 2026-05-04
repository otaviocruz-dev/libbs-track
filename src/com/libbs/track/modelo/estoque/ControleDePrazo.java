package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Monitora a proximidade do vencimento de um Lote.
 * Calcula e classifica o status automaticamente — encapsulamento:
 * ninguém de fora precisa saber como a classificação é feita.
 *
 * Status possíveis: OK | ALERTA | CRITICO | VENCIDO
 */
public class ControleDePrazo {

    private final Lote   loteMonitorado;
    private final int    limiteAlertaDias;
    private int          diasParaVencer;
    private String       statusPrazo;

    public ControleDePrazo(Lote loteMonitorado, int limiteAlertaDias) {
        this.loteMonitorado  = loteMonitorado;
        this.limiteAlertaDias = limiteAlertaDias;
        calcularStatus();
    }

    /**
     * Recalcula diasParaVencer e statusPrazo com base na data de hoje.
     * Deve ser chamado periodicamente pelo sistema para manter o status atualizado.
     */
    public void calcularStatus() {
        diasParaVencer = (int) ChronoUnit.DAYS.between(
                LocalDate.now(), loteMonitorado.getDataValidade());

        if (diasParaVencer <= 0)                  statusPrazo = "VENCIDO";
        else if (diasParaVencer <= 30)             statusPrazo = "CRITICO";
        else if (diasParaVencer <= limiteAlertaDias) statusPrazo = "ALERTA";
        else                                       statusPrazo = "OK";
    }

    /** Retorna true se o status exige geração de um AlertaIA. */
    public boolean precisaDeAlerta() {
        return "ALERTA".equals(statusPrazo) || "CRITICO".equals(statusPrazo) || "VENCIDO".equals(statusPrazo);
    }

    // Getters
    public Lote   getLoteMonitorado()  { return loteMonitorado; }
    public int    getLimiteAlertaDias(){ return limiteAlertaDias; }
    public int    getDiasParaVencer()  { return diasParaVencer; }
    public String getStatusPrazo()     { return statusPrazo; }

    @Override
    public String toString() {
        return "ControleDePrazo{" +
                "lote=" + loteMonitorado.getCodigoLote() +
                ", diasParaVencer=" + diasParaVencer +
                ", status='" + statusPrazo + '\'' +
                '}';
    }
}