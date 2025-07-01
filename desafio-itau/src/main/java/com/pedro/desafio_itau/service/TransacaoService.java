package com.pedro.desafio_itau.service;

import com.pedro.desafio_itau.dto.TransacaoRequest;
import com.pedro.desafio_itau.entity.Transacao;
import com.pedro.desafio_itau.entity.Validacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    private final List<Validacao> validacao;

    public TransacaoService(List<Validacao> validacao) {
        this.validacao = validacao;
    }

    public void salvar(TransacaoRequest request){
        validacao.forEach(v -> v.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }

    public void deletar(){
        validacao.clear();
    }

    public List<Transacao> getTransacoes(){
        return transacoes;
    }
}
