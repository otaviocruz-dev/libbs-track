package com.libbs.track.modelo.produto;

import java.time.LocalDate;

/**
 * Registra a solicitação de fabricação de um lote.
 * É o ponto de partida da cadeia produtiva da Libbs.
 */
public class OrdemProducao {

    private final Lote      lote;
    private final String    responsavel;
    private final LocalDate data;
    private final int       quantidadePlanejada;
    private int             quantidadeProduzida;
    private String          status; // "ABERTA", "EM_PRODUCAO", "CONCLUIDA", "CANCELADA"

    public OrdemProducao(Lote lote, String responsavel, int quantidadePlanejada) {
        this.lote                = lote;
        this.responsavel         = responsavel;
        this.quantidadePlanejada = quantidadePlanejada;
        this.quantidadeProduzida = 0;
        this.data                = LocalDate.now();
        this.status              = "ABERTA";
    }

    // Getters
    public Lote      getLote()                 { return lote; }
    public String    getResponsavel()          { return responsavel; }
    public LocalDate getData()                 { return data; }
    public int       getQuantidadePlanejada()  { return quantidadePlanejada; }
    public int       getQuantidadeProduzida()  { return quantidadeProduzida; }
    public String    getStatus()               { return status; }

    // Setters seletivos
    public void setQuantidadeProduzida(int qtd) { this.quantidadeProduzida = qtd; }
    public void setStatus(String status)        { this.status = status; }

    /** Percentual de conclusão da ordem. */
    public double getPercentualConclusao() {
        if (quantidadePlanejada == 0) return 0;
        return (quantidadeProduzida * 100.0) / quantidadePlanejada;
    }

    @Override
    public String toString() {
        return "OrdemProducao{" +
                "lote=" + lote.getCodigoLote() +
                ", responsavel='" + responsavel + '\'' +
                ", planejado=" + quantidadePlanejada +
                ", produzido=" + quantidadeProduzida +
                ", status='" + status + '\'' +
                '}';
    }
}