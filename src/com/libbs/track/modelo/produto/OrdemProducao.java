package com.libbs.track.modelo.produto;

import java.time.LocalDate;

public class OrdemProducao {

    private Lote lote;
    private String responsavel;
    private LocalDate data;
    private int quantidadePlanejada;
    private int quantidadeProduzida;

    public OrdemProducao(Lote lote, String responsavel,
                         int quantidadePlanejada) {
        this.lote = lote;
        this.responsavel = responsavel;
        this.quantidadePlanejada = quantidadePlanejada;
        this.data = LocalDate.now();
    }
}