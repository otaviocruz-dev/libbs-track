package com.libbs.track.modelo.regulatorio;

import com.libbs.track.modelo.pessoa.Farmaceutico;
import com.libbs.track.modelo.produto.Lote;
import java.time.LocalDate;

/**
 * Registro da inspeção de qualidade realizada em um Lote.
 * A Anvisa exige (BPF RDC 658/2022) que lotes sejam inspecionados
 * por farmacêutico habilitado antes da liberação para distribuição.
 *
 * Oferece dois modos de criação:
 * - Construtor completo (recomendado): objeto já nasce em estado válido
 * - Construtor vazio + setters: compatível com versão anterior
 */
public class InspecaoDeQualidade {

    private Lote          loteInspecionado;
    private Farmaceutico  farmaceuticoResponsavel;
    private LocalDate     dataInspecao;
    private String        resultado;    // "APROVADO", "REPROVADO", "PENDENTE"
    private String        observacoes;

    /** Construtor vazio — mantido para compatibilidade com código existente. */
    public InspecaoDeQualidade() {}

    /** Construtor completo — preferível pois garante estado válido na criação. */
    public InspecaoDeQualidade(Lote loteInspecionado, Farmaceutico farmaceuticoResponsavel,
                               LocalDate dataInspecao, String resultado, String observacoes) {
        this.loteInspecionado         = loteInspecionado;
        this.farmaceuticoResponsavel  = farmaceuticoResponsavel;
        this.dataInspecao             = dataInspecao;
        this.resultado                = resultado;
        this.observacoes              = observacoes;
    }

    /** Retorna true se o lote foi aprovado e pode seguir para estoque. */
    public boolean isAprovada() {
        return "APROVADO".equals(resultado);
    }

    // Getters
    public Lote         getLoteInspecionado()        { return loteInspecionado; }
    public Farmaceutico getFarmaceuticoResponsavel() { return farmaceuticoResponsavel; }
    public LocalDate    getDataInspecao()            { return dataInspecao; }
    public String       getResultado()               { return resultado; }
    public String       getObservacoes()             { return observacoes; }

    // Setters
    public void setLoteInspecionado(Lote loteInspecionado)                       { this.loteInspecionado = loteInspecionado; }
    public void setFarmaceuticoResponsavel(Farmaceutico farmaceuticoResponsavel) { this.farmaceuticoResponsavel = farmaceuticoResponsavel; }
    public void setDataInspecao(LocalDate dataInspecao)                          { this.dataInspecao = dataInspecao; }
    public void setResultado(String resultado)                                   { this.resultado = resultado; }
    public void setObservacoes(String observacoes)                               { this.observacoes = observacoes; }

    @Override
    public String toString() {
        return "InspecaoDeQualidade{" +
                "lote=" + (loteInspecionado != null ? loteInspecionado.getCodigoLote() : "N/A") +
                ", responsavel='" + (farmaceuticoResponsavel != null ? farmaceuticoResponsavel.getNome() : "N/A") + '\'' +
                ", data=" + dataInspecao +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}