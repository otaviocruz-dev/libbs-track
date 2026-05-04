package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDateTime;

/**
 * Registro imutável de cada movimentação de um Lote no sistema.
 * É o "log" da cadeia logística — a Anvisa exige que cada movimento
 * seja registrado e auditável.
 *
 * Uma vez criado, o registro não pode ser alterado (imutabilidade total).
 */
public class RastreabilidadeMovimentacao {

    private final Long          id;
    private final Lote          lote;
    private final String        origem;
    private final String        destino;
    private final Double        quantidade;
    private final LocalDateTime dataHora;

    public RastreabilidadeMovimentacao(Long id, Lote lote,
                                       String origem, String destino,
                                       Double quantidade) {
        this.id         = id;
        this.lote       = lote;
        this.origem     = origem;
        this.destino    = destino;
        this.quantidade = quantidade;
        this.dataHora   = LocalDateTime.now();
    }

    // Getters — sem setters: registros de movimentação são imutáveis
    public Long          getId()        { return id; }
    public Lote          getLote()      { return lote; }
    public String        getOrigem()    { return origem; }
    public String        getDestino()   { return destino; }
    public Double        getQuantidade(){ return quantidade; }
    public LocalDateTime getDataHora()  { return dataHora; }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", lote=" + lote.getCodigoLote() +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", quantidade=" + quantidade +
                ", dataHora=" + dataHora +
                '}';
    }
}