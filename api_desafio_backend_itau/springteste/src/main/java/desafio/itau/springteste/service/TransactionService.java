package desafio.itau.springteste.service;

import desafio.itau.springteste.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    public Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void  clearTransaction() {
        transactions.remove();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();

        return transactions.stream().filter(transaction ->
                transaction.getDatahora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor).summaryStatistics();
    }
}
