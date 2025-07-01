package com.pedro.desafio_itau.entity;

import com.pedro.desafio_itau.dto.TransacaoRequest;

public interface Validacao {

    void validar(TransacaoRequest request);
}
