package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDateTime;

public class RastreabilidadeMovimentacao {

    private Long id;
    private Lote lote;
    private String origem;
    private String destino;
    private Double quantidade;
    private LocalDateTime dataHora;

    public RastreabilidadeMovimentacao(Long id, Lote lote,
                                       String origem, String destino,
                                       Double quantidade) {
        this.id = id;
        this.lote = lote;
        this.origem = origem;
        this.destino = destino;
        this.quantidade = quantidade;
        this.dataHora = LocalDateTime.now();
    }
}