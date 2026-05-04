package com.libbs.track.modelo.logistica;

import java.util.Objects;

/**
 * Empresa que fornece matéria-prima ou embalagens para a Libbs.
 * A Anvisa exige que fornecedores sejam qualificados e registrados.
 */
public class Fornecedor {

    private final String nome;
    private final String cnpj;
    private String       materiaPrima;
    private String       certificacaoAnvisa; // ex: "BPF", "ISO 9001"
    private String       status;             // "ATIVO", "SUSPENSO", "DESCREDENCIADO"

    public Fornecedor(String nome, String cnpj, String materiaPrima) {
        this.nome          = nome;
        this.cnpj          = cnpj;
        this.materiaPrima  = materiaPrima;
        this.status        = "ATIVO";
    }

    // Getters
    public String getNome()               { return nome; }
    public String getCnpj()               { return cnpj; }
    public String getMateriaPrima()       { return materiaPrima; }
    public String getCertificacaoAnvisa() { return certificacaoAnvisa; }
    public String getStatus()             { return status; }

    // Setters seletivos
    public void setMateriaPrima(String materiaPrima)             { this.materiaPrima = materiaPrima; }
    public void setCertificacaoAnvisa(String certificacaoAnvisa) { this.certificacaoAnvisa = certificacaoAnvisa; }
    public void setStatus(String status)                         { this.status = status; }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", materiaPrima='" + materiaPrima + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor f = (Fornecedor) o;
        return Objects.equals(cnpj, f.cnpj);
    }

    @Override
    public int hashCode() { return Objects.hash(cnpj); }
}