package com.api.itau.service;

import com.api.itau.dto.EstatisticaDTO;
import com.api.itau.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private final TransactionService transactionService;


    public EstatisticaService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public EstatisticaDTO estatisticaDTO(Integer intervaloBusca) {
        List<TransactionDTO> transacoes = transactionService.buscarTransacao(intervaloBusca);

        DoubleSummaryStatistics transactionStatistics = transacoes.stream().mapToDouble(TransactionDTO::valor).summaryStatistics();

        return new EstatisticaDTO((int) transactionStatistics.getCount(), transactionStatistics.getSum()
                , transactionStatistics.getAverage(), transactionStatistics.getMin(), transactionStatistics.getMax());

    }
}
