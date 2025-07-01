package com.pedro.desafio_itau.controller;

import com.pedro.desafio_itau.dto.EstatisticasResponse;
import com.pedro.desafio_itau.service.EstatisticasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    private final EstatisticasService service;


    public EstatisticasController(EstatisticasService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EstatisticasResponse obterMetricas(){
        return service.obterEstatisticas();
    }
}
