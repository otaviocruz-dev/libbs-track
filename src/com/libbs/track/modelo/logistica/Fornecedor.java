package com.libbs.track.modelo.logistica;

public class Fornecedor {

    private String nome;
    private String cnpj;
    private String materiaPrima;

    public Fornecedor(String nome, String cnpj, String materiaPrima) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.materiaPrima = materiaPrima;
    }
}