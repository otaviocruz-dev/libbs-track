package com.libbs.track.modelo;

import com.libbs.track.modelo.estoque.RastreabilidadeMovimentacao;
import com.libbs.track.modelo.produto.Lote;
import com.libbs.track.modelo.produto.Medicamento;

import java.util.List;

public class SistemaGerenciamentoLibbs {
    private List<Lote> lotes;
    private List<Medicamento> produtos;
    private List<RastreabilidadeMovimentacao> movimentacoes;
    private String nomeSistema;
    private String versao;
    private String usuarioAtual;
}
