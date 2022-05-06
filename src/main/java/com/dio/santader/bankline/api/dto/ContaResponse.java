package com.dio.santader.bankline.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class ContaResponse {

    @JsonProperty("numero")
    private Long numero;

    @JsonProperty("saldo")
    private  Double saldo;

    public ContaResponse(Long numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
}
