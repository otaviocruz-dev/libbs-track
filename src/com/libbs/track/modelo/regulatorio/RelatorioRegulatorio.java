package com.libbs.track.modelo.regulatorio;

import com.libbs.track.modelo.pessoa.Farmaceutico;
import java.time.LocalDate;

/**
 * Documento oficial gerado para submissão à Anvisa ou auditorias internas.
 * Todo relatório precisa de um farmacêutico responsável para ter validade legal.
 *
 * Oferece dois modos de criação:
 * - Construtor completo (recomendado): objeto já nasce em estado válido
 * - Construtor vazio + setters: compatível com código existente no Principal.java
 */
public class RelatorioRegulatorio {

    private String       codigoRelatorio;
    private String       tipoRelatorio;  // "INSPECAO", "RECALL", "FARMACOVIGILANCIA"
    private LocalDate    dataEmissao;
    private Farmaceutico farmaceuticoResponsavel;
    private String       conteudo;

    /** Construtor vazio — mantido para compatibilidade. */
    public RelatorioRegulatorio() {}

    /** Construtor completo — preferível pois garante estado válido na criação. */
    public RelatorioRegulatorio(String codigoRelatorio, String tipoRelatorio,
                                LocalDate dataEmissao, Farmaceutico farmaceuticoResponsavel,
                                String conteudo) {
        this.codigoRelatorio        = codigoRelatorio;
        this.tipoRelatorio          = tipoRelatorio;
        this.dataEmissao            = dataEmissao;
        this.farmaceuticoResponsavel = farmaceuticoResponsavel;
        this.conteudo               = conteudo;
    }

    /** Retorna cabeçalho resumido — útil para listagens sem expor o conteúdo completo. */
    public String getCabecalho() {
        return "[" + codigoRelatorio + "] " + tipoRelatorio
                + " — " + dataEmissao
                + " | Resp.: " + (farmaceuticoResponsavel != null ? farmaceuticoResponsavel.getNome() : "N/A");
    }

    /** Verifica se o relatório ainda está dentro do prazo de validade. */
    public boolean estaValido(int mesesDeValidade) {
        if (dataEmissao == null) return false;
        return LocalDate.now().isBefore(dataEmissao.plusMonths(mesesDeValidade));
    }

    // Getters
    public String       getCodigoRelatorio()         { return codigoRelatorio; }
    public String       getTipoRelatorio()            { return tipoRelatorio; }
    public LocalDate    getDataEmissao()              { return dataEmissao; }
    public Farmaceutico getFarmaceuticoResponsavel()  { return farmaceuticoResponsavel; }
    public String       getConteudo()                 { return conteudo; }

    // Setters
    public void setCodigoRelatorio(String codigoRelatorio)                        { this.codigoRelatorio = codigoRelatorio; }
    public void setTipoRelatorio(String tipoRelatorio)                            { this.tipoRelatorio = tipoRelatorio; }
    public void setDataEmissao(LocalDate dataEmissao)                             { this.dataEmissao = dataEmissao; }
    public void setFarmaceuticoResponsavel(Farmaceutico farmaceuticoResponsavel)  { this.farmaceuticoResponsavel = farmaceuticoResponsavel; }
    public void setConteudo(String conteudo)                                      { this.conteudo = conteudo; }

    @Override
    public String toString() {
        return "RelatorioRegulatorio{" +
                "codigo='" + codigoRelatorio + '\'' +
                ", tipo='" + tipoRelatorio + '\'' +
                ", emissao=" + dataEmissao +
                ", responsavel='" + (farmaceuticoResponsavel != null ? farmaceuticoResponsavel.getNome() : "N/A") + '\'' +
                '}';
    }
}