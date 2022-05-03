package com.dio.santader.bankline.api.controller;

import com.dio.santader.bankline.api.dto.NovaMovimentacao;
import com.dio.santader.bankline.api.model.Movimentacao;
import com.dio.santader.bankline.api.repository.MovimentacaoRepository;
import com.dio.santader.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        service.save(movimentacao);

    }
}
