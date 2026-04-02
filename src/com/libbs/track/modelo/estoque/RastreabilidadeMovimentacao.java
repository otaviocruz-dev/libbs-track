package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.Lote;

import java.time.LocalDateTime;

public class RastreabilidadeMovimentacao {
    private Long id;
    private Lote loteMonitorado;
    private String codigoProduto;
    private LocalDateTime dataHoraRastreio;
    private Double quantidade;
    private String localizacaoOrigem;
    private String localizacaoDestino;
}
