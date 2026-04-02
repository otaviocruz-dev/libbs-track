package com.libbs.track.modelo.logistica;
import com.libbs.track.modelo.produto.Lote;
import com.libbs.track.modelo.logistica.PedidoEntrega;

public class Fornecedor {
    private String materiaPrima;
    private String embalagens;
    private String regulamentoAnvisa;
    private Lote loteLocal;
    private PedidoEntrega pedidoEntrega;

    public String getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(String materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(String embalagens) {
        this.embalagens = embalagens;
    }

    public String getRegulamentoAnvisa() {
        return regulamentoAnvisa;
    }

    public void setRegulamentoAnvisa(String regulamentoAnvisa) {
        this.regulamentoAnvisa = regulamentoAnvisa;
    }

    public Lote getLoteLocal() {
        return loteLocal;
    }

    public void setLoteLocal(Lote loteLocal) {
        this.loteLocal = loteLocal;
    }

    public PedidoEntrega getPedidoEntrega() {
        return pedidoEntrega;
    }

    public void setPedidoEntrega(PedidoEntrega pedidoEntrega) {
        this.pedidoEntrega = pedidoEntrega;
    }
}
