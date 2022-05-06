package com.dio.santader.bankline.api.controller;

import com.dio.santader.bankline.api.dto.MovimentacaoResponse;
import com.dio.santader.bankline.api.dto.NovaMovimentacao;
import com.dio.santader.bankline.api.model.Movimentacao;
import com.dio.santader.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

      @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{idConta}")
    public List<MovimentacaoResponse>findAll(@PathVariable("idConta") Integer idConta){
        List<Movimentacao> byIdConta = service.findByIdConta(idConta);
        return MovimentacaoResponse.wrapper(byIdConta) ;
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        service.save(movimentacao);

    }

}
