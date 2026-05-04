package com.libbs.track.modelo;

import com.libbs.track.modelo.estoque.RastreabilidadeMovimentacao;
import com.libbs.track.modelo.produto.Lote;
import com.libbs.track.modelo.produto.Medicamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Orquestrador central do sistema LibbsTrack.
 * Agrega as principais entidades e fornece uma visão consolidada
 * do estado do sistema — padrão Façade.
 */
public class SistemaGerenciamentoLibbs {

    private final List<Lote>                          lotes;
    private final List<Medicamento>                   produtos;
    private final List<RastreabilidadeMovimentacao>   movimentacoes;
    private final String                              nomeSistema;
    private final String                              versao;
    private String                                    usuarioAtual;

    public SistemaGerenciamentoLibbs(List<Lote> lotes, List<Medicamento> produtos,
                                     List<RastreabilidadeMovimentacao> movimentacoes,
                                     String nomeSistema, String versao, String usuarioAtual) {
        this.lotes         = lotes != null ? lotes : new ArrayList<>();
        this.produtos      = produtos != null ? produtos : new ArrayList<>();
        this.movimentacoes = movimentacoes != null ? movimentacoes : new ArrayList<>();
        this.nomeSistema   = nomeSistema;
        this.versao        = versao;
        this.usuarioAtual  = usuarioAtual;
    }

    // Getters
    public List<Lote>                        getLotes()         { return Collections.unmodifiableList(lotes); }
    public List<Medicamento>                 getProdutos()      { return Collections.unmodifiableList(produtos); }
    public List<RastreabilidadeMovimentacao> getMovimentacoes() { return Collections.unmodifiableList(movimentacoes); }
    public String                            getNomeSistema()   { return nomeSistema; }
    public String                            getVersao()        { return versao; }
    public String                            getUsuarioAtual()  { return usuarioAtual; }

    // Setter seletivo — somente usuário pode mudar em runtime
    public void setUsuarioAtual(String usuarioAtual) { this.usuarioAtual = usuarioAtual; }

    @Override
    public String toString() {
        return "SistemaGerenciamentoLibbs{" +
                "nome='" + nomeSistema + '\'' +
                ", versao='" + versao + '\'' +
                ", usuario='" + usuarioAtual + '\'' +
                ", lotes=" + lotes.size() +
                ", produtos=" + produtos.size() +
                ", movimentacoes=" + movimentacoes.size() +
                '}';
    }
}