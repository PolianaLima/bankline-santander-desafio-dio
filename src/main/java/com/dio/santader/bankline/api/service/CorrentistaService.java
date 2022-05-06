package com.dio.santader.bankline.api.service;

import com.dio.santader.bankline.api.dto.NovoCorrentista;
import com.dio.santader.bankline.api.model.Conta;
import com.dio.santader.bankline.api.model.Correntista;
import com.dio.santader.bankline.api.model.Movimentacao;
import com.dio.santader.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CorrentistaService {


    @Autowired
    private CorrentistaRepository repository;

    public CorrentistaService() {
    }



    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());

        Correntista byCpf = repository.findByCpf(novoCorrentista.getCpf());
        if(byCpf != null){
            throw new RuntimeException("CPF ja está cadastrado");
        }

        correntista.setNome(novoCorrentista.getNome().toUpperCase());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());



        correntista.setConta((conta));
        repository.save(correntista);
    }

    public List<Correntista> findAll() {
         return repository.findAll();
    }
}

