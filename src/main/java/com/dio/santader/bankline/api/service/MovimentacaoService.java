package com.dio.santader.bankline.api.service;

import com.dio.santader.bankline.api.dto.NovaMovimentacao;
import com.dio.santader.bankline.api.model.Correntista;
import com.dio.santader.bankline.api.model.Movimentacao;
import com.dio.santader.bankline.api.model.MovimentacaoTipo;
import com.dio.santader.bankline.api.repository.CorrentistaRepository;
import com.dio.santader.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;


    public void save(NovaMovimentacao novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getValor();

        if (novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA) {
            valor = valor * -1;
        }

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao().toUpperCase());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if (correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo()+valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);


    }

    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    public List<Movimentacao> findByIdConta(Integer idConta) {
        return repository.findByIdConta(idConta);
    }
}
