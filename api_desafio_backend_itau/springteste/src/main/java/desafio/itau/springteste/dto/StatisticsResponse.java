package desafio.itau.springteste.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {

    private final Long count;
    private final Double sum;
    private final Double avg;
    private final Double min;
    private final Double max;

    public StatisticsResponse(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
    }

    public Long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }
}
