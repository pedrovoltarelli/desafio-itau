package com.pedro.desafio_itau.dto;

import java.time.OffsetDateTime;

public record TransacaoRequest (Double valor, OffsetDateTime dataHora){

}
