package com.pedro.desafio_itau.controller;

import com.pedro.desafio_itau.dto.TransacaoRequest;
import com.pedro.desafio_itau.service.TransacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public void salvar(@RequestBody TransacaoRequest request){
        service.salvar(request);
    }
}
