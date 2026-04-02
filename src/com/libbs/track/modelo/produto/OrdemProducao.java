package com.libbs.track.modelo.produto;

import com.libbs.track.modelo.produto.Lote;

import java.time.LocalDate;

public class OrdemProducao {
    private Lote loteMonitorado;
    private String codigoProduto;
    private String responsavelProducao;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private int quantidadePlanejada;
    private int quantidadeProduzida;

}
