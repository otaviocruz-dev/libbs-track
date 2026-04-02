package com.libbs.track.modelo.logistica;

import com.libbs.track.modelo.logistica.Distribuidor;
import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDate;

/**
 * Solicitação de envio de um lote para um distribuidor.
 * Conecta Lote + Distribuidor com quantidade e prazo.
 */
public class PedidoEntrega {

    private String       codigoPedido;
    private Lote         loteEnviado;
    private Distribuidor destinatario;
    private Integer      quantidadeEnviada;
    private LocalDate    dataEnvio;
    private String       statusPedido;    // "PENDENTE", "ENVIADO", "ENTREGUE", "CANCELADO"

    public PedidoEntrega(String codigoPedido, Lote loteEnviado, Distribuidor destinatario,
                         Integer quantidadeEnviada, LocalDate dataEnvio, String statusPedido) {
        this.codigoPedido     = codigoPedido;
        this.loteEnviado      = loteEnviado;
        this.destinatario     = destinatario;
        this.quantidadeEnviada = quantidadeEnviada;
        this.dataEnvio        = dataEnvio;
        this.statusPedido     = statusPedido;
    }

    public String       getCodigoPedido()      { return codigoPedido; }
    public Lote         getLoteEnviado()        { return loteEnviado; }
    public Distribuidor getDestinatario()       { return destinatario; }
    public Integer      getQuantidadeEnviada()  { return quantidadeEnviada; }
    public LocalDate    getDataEnvio()          { return dataEnvio; }
    public String       getStatusPedido()       { return statusPedido; }

    public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }

    @Override
    public String toString() {
        return "PedidoEntrega{codigo='" + codigoPedido + "', destino='" + destinatario.getNomeDistribuidor() + "', status='" + statusPedido + "'}";
    }
}