package com.libbs.track.modelo.ia;

import com.libbs.track.modelo.produto.Medicamento;
import java.time.LocalDate;

/**
 * Resultado gerado pelo ModeloIA com a estimativa de demanda
 * de um medicamento para um período futuro.
 * Alimenta a OrdemProducao para evitar falta ou excesso de estoque.
 */
public class PrevisaoDaDemanda {

    private final Medicamento medicamento;
    private final int         quantidadePrevista;
    private final String      periodo;      // ex: "2025-06"
    private final LocalDate   dataGeracao;  // definida automaticamente
    private final double      acuracia;     // ex: 0.91 = 91%

    public PrevisaoDaDemanda(Medicamento medicamento, int quantidadePrevista,
                             String periodo, double acuracia) {
        this.medicamento        = medicamento;
        this.quantidadePrevista = quantidadePrevista;
        this.periodo            = periodo;
        this.acuracia           = acuracia;
        this.dataGeracao        = LocalDate.now();
    }

    // Getters — objeto imutável após criação
    public Medicamento getMedicamento()        { return medicamento; }
    public int         getQuantidadePrevista() { return quantidadePrevista; }
    public String      getPeriodo()            { return periodo; }
    public LocalDate   getDataGeracao()        { return dataGeracao; }
    public double      getAcuracia()           { return acuracia; }

    /** Retorna a acurácia formatada em percentual para exibição. */
    public String getAcuraciaFormatada() {
        return String.format("%.1f%%", acuracia * 100);
    }

    @Override
    public String toString() {
        return "PrevisaoDaDemanda{" +
                "medicamento='" + medicamento.getNomeComercial() + '\'' +
                ", periodo='" + periodo + '\'' +
                ", quantidade=" + quantidadePrevista +
                ", acuracia=" + getAcuraciaFormatada() +
                '}';
    }
}