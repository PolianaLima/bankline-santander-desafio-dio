package com.dio.santader.bankline.api.dto;

import com.dio.santader.bankline.api.model.Correntista;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CorrentistaResponse {

    @JsonProperty("id")
    private Integer idConta;
    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("conta")
    private ContaResponse conta;

    public CorrentistaResponse(Integer idConta, String cpf, String nome, ContaResponse conta) {
        this.idConta = idConta;
        this.cpf = cpf;
        this.nome = nome;
        this.conta = conta;
    }

    public static List<CorrentistaResponse> wrapper(List<Correntista> correntistaList) {
        List<CorrentistaResponse> correntistaResponseList = new ArrayList<>();
        for (Correntista i : correntistaList) {
            correntistaResponseList.add(new CorrentistaResponse(
                    i.getId(),
                    i.getCpf(),
                    i.getNome(),
                    new ContaResponse(
                            i.getConta().getNumero(),
                            i.getConta().getSaldo()
                    )
            ));
        }

        return correntistaResponseList;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public ContaResponse getConta() {
        return conta;
    }

    public Integer getIdConta() {
        return idConta;
    }
}
