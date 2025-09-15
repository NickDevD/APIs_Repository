package desafio.itau.springteste.controller;

import desafio.itau.springteste.dto.StatisticsResponse;
import desafio.itau.springteste.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping
public class StatisticController {

    private final TransactionService transactionService;

    public StatisticController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/statistic")
    public ResponseEntity<StatisticsResponse> getStatistic(){
        DoubleSummaryStatistics statistics = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponse(statistics));
    }
}
