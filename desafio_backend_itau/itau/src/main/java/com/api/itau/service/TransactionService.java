package com.api.itau.service;

import com.api.itau.UnprocessableEntity;
import com.api.itau.dto.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    private final List<TransactionDTO> transactionDTOList = new ArrayList<>();

    public void addTransaction(TransactionDTO dto){

        log.info("Iniciando servico de transferencia bancaria");

        if (dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("dataHora não é válida");
            throw new UnprocessableEntity("Data e hora inválidos");
        }
        if (dto.valor() < 0){
            log.error("Valores inferiores a 0 não são aceitos");
            throw new UnprocessableEntity("Valor null");
        }

        transactionDTOList.add(dto);
    }

    public void clearTransaction(){
        transactionDTOList.clear();
    }

    public List<TransactionDTO> buscarTransacao(Integer intervaloBusca){

        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return transactionDTOList.stream().filter(transacoes -> transacoes.dataHora().isAfter(dataHoraIntervalo)).toList();
    }
}
