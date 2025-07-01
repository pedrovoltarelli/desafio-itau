package com.pedro.desafio_itau.service;

import com.pedro.desafio_itau.dto.EstatisticasResponse;
import com.pedro.desafio_itau.entity.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticasService {

    TransacaoService service;

    public EstatisticasResponse obterEstatisticas(){
        OffsetDateTime ultimoMinuto = OffsetDateTime.now().minusSeconds(60);

        List<Transacao> transacaoFiltradas = service.getTransacoes().stream().filter(t ->
                t.getDataHora().isAfter(ultimoMinuto)).toList();

        DoubleSummaryStatistics estatisticas = transacaoFiltradas.stream().mapToDouble(Transacao::getValor)
                .summaryStatistics();

        double min = estatisticas.getCount() > 0 ? estatisticas.getMin() : 0.0;
        double max = estatisticas.getCount() > 0 ? estatisticas.getMax() : 0.0;

        return new EstatisticasResponse(estatisticas.getCount(), estatisticas.getSum(),
                estatisticas.getAverage(), min, max);
    }
}
