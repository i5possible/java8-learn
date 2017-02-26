package java8inaction.stream.traders;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class Transactions {
    public static final String CAMBRIDGE = "Cambridge";
    public static final String MILAN = "Milan";

    public static final Trader raoul = new Trader("Raoul", CAMBRIDGE);
    public static final Trader mario = new Trader("Mario", MILAN);
    public static final Trader alan = new Trader("Alan", CAMBRIDGE);
    public static final Trader brian = new Trader("Brian", CAMBRIDGE);
    public static final List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(alan, 2012, 950)
    );

    public List<Transaction> findTransactionIn2011SortByValue(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> 2011 == transaction.getYear())
                .sorted((a, b) -> Integer.compare(a.getValue(), b.getValue()))
                .collect(Collectors.toList());

    }

    public Set<String> findAllCityTraderWorked(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toSet());
    }

    public List<Trader> findTraderFromCambridgeSortByName(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(CAMBRIDGE))
                .distinct()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .collect(Collectors.toList());
    }

    public List<String> findAllTraderNameSortByAlphabet(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

    }

    public boolean isAnyTraderWorkedInMilan(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> MILAN.equals(trader.getCity()))
                .findAny()
                .isPresent();

    }

    public Set<Integer> findTheValueThatTraderLivedInCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> CAMBRIDGE.equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toSet());
    }

    public int findTheMaxValue(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);

    }

    public Transaction findTheTransactionHasTheMinimumValue(List<Transaction> transactions) {
        assert transactions.size() > 0;
        return  transactions.stream()
                .sorted((a, b) -> Integer.min(a.getValue(), b.getValue()))
                .findFirst().get();

    }
}
