package com.dio.santader.bankline.api.dto;

import com.dio.santader.bankline.api.model.Movimentacao;
import com.dio.santader.bankline.api.model.MovimentacaoTipo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class MovimentacaoResponse {

    @JsonProperty("idConta")
    private Integer idConta;

    @JsonProperty("dataHora")
    private String dataHora;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("valor")
    private Double valor;

    @JsonProperty("tipo")
    private MovimentacaoTipo tipo;

    public MovimentacaoResponse(Integer idConta,
                                String dataHora,
                                String descricao,
                                Double valor,
                                MovimentacaoTipo tipo) {
        this.idConta = idConta;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public static List<MovimentacaoResponse> wrapper(List<Movimentacao> movimentacoes) {
        List<MovimentacaoResponse>movimentacaoResponseList = new ArrayList<>();
        for (Movimentacao i: movimentacoes){
            movimentacaoResponseList.add(new MovimentacaoResponse(
                    i.getIdConta(),
                    i.getDataHora().toString(),
                    i.getDescricao(),
                    i.getValor(),
                    i.getTipo()
            ));
        }

        return movimentacaoResponseList;

    }
}
