package com.libbs.track.modelo.produto;

import java.time.LocalDate;

public class Lote {

    private int codigoLote;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private int quantidade;
    private String status;

    public Lote(int codigoLote, LocalDate fabricacao,
                LocalDate validade, int quantidade) {
        this.codigoLote = codigoLote;
        this.dataFabricacao = fabricacao;
        this.dataValidade = validade;
        this.quantidade = quantidade;
        this.status = "ATIVO";
    }

    public int getCodigoLote() { return codigoLote; }
    public LocalDate getDataValidade() { return dataValidade; }
}