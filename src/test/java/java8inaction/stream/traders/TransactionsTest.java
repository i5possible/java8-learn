package java8inaction.stream.traders;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java8inaction.stream.traders.Transactions.brian;
import static java8inaction.stream.traders.Transactions.raoul;

public class TransactionsTest {
    private List<Transaction> transactionList;
    private Transactions transactions;

    @Before
    public void setUp() throws Exception {
        transactionList = Transactions.transactions;
        transactions = new Transactions();
    }

    @Test
    public void shouldReturnTransactionsIn2011AndSorted() {
        List<Transaction> expected = new ArrayList<>(Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2011, 400)
        ));

        List<Transaction> actual = transactions.findTransactionIn2011SortByValue(transactionList);

        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void shouldReturnAllCityThatTradersWorked() {
        Set<String> expected = new HashSet<>();
        expected.add("Cambridge");
        expected.add("Milan");

        Set<String> actual = transactions.findAllCityTraderWorked(transactionList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedTradersFromCambridge() {
        List<Trader> expected = new ArrayList<>(Arrays.asList(
                Transactions.alan,
                Transactions.brian,
                Transactions.raoul
        ));

        List<Trader> actual = transactions.findTraderFromCambridgeSortByName(transactionList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedAllTraderNames() {
        String expected = "AlanBrianMarioRaoul";

        String actual = transactions.findAllTraderNameSortByAlphabet(transactionList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueWhenAskIfAnyTraderWorkedInMilan() {
        Assert.assertTrue(transactions.isAnyTraderWorkedInMilan(transactionList));
    }

    @Test
    public void shouldReturnAllTheValueOfCambridge() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(
                300, 1000, 400, 950
        ));

        Set<Integer> actual = transactions.findTheValueThatTraderLivedInCambridge(transactionList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMaxValue() {
        int expected = 1000;

        int actual = transactions.findTheMaxValue(transactionList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinValueTransaction() {
        Transaction expected = new Transaction(Transactions.brian, 2011, 300);

        Transaction actual = transactions.findTheTransactionHasTheMinimumValue(transactionList);

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}