package com.libbs.track.modelo.ia;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDateTime;

/**
 * Notificação gerada automaticamente pelo sistema de IA
 * quando um risco é detectado (validade, estoque baixo, desvio de qualidade).
 */
public class AlertaIA {

    private String        tipoAlerta;       // "VALIDADE", "ESTOQUE_BAIXO", "DESVIO_QUALIDADE"
    private String        nivelRisco;       // "BAIXO", "MEDIO", "ALTO", "CRITICO"
    private Lote          loteAfetado;
    private LocalDateTime dataHoraAlerta;
    private String        mensagem;

    public AlertaIA(String tipoAlerta, String nivelRisco,
                    Lote loteAfetado, LocalDateTime dataHoraAlerta, String mensagem) {
        this.tipoAlerta    = tipoAlerta;
        this.nivelRisco    = nivelRisco;
        this.loteAfetado   = loteAfetado;
        this.dataHoraAlerta = dataHoraAlerta;
        this.mensagem      = mensagem;
    }

    public String        getTipoAlerta()    { return tipoAlerta; }
    public String        getNivelRisco()    { return nivelRisco; }
    public Lote          getLoteAfetado()   { return loteAfetado; }
    public LocalDateTime getDataHoraAlerta(){ return dataHoraAlerta; }
    public String        getMensagem()      { return mensagem; }

    @Override
    public String toString() {
        return "[ALERTA-IA] " + nivelRisco + " | " + tipoAlerta + " | Lote: " + loteAfetado.getCodigoLote() + " | " + mensagem;
    }
}