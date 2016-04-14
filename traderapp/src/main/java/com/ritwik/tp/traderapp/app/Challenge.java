package com.ritwik.tp.traderapp.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ritwik.tp.traderapp.api.TradersAPIClient;
import com.ritwik.tp.traderapp.api.TransactionsAPIClient;
import com.ritwik.tp.traderapp.dto.Trader;
import com.ritwik.tp.traderapp.dto.Transaction;

/**
 * @author ritwik.kumar
 *
 */
public class Challenge {
    private static final TradersAPIClient TRADERS_CLIENT = TradersAPIClient.getInstance();
    private static final TransactionsAPIClient TRANS_CLIENT = TransactionsAPIClient.getInstance();

    /**
     * Find all traders from Singapore and sort them by name
     *
     * @return
     */
    private List<Trader> getSGPTraders() {
        final List<Trader> allTraders = TRADERS_CLIENT.getTraders();
        final List<Trader> sortedSgpTraders = new ArrayList<>();
        // Filter and sort
        allTraders.stream().filter(p -> p.getCity().equalsIgnoreCase("Singapore")).sorted()
                .forEach(sortedSgpTraders::add);
        return sortedSgpTraders;

    }

    /**
     * Find the transaction with the highest value
     *
     * @return
     */
    private Transaction findHighestValTransaction() {
        final List<Transaction> allTransactions = TRANS_CLIENT.getTransactions();
        Transaction higTransaction = allTransactions.get(0);
        for (final Transaction transaction : allTransactions) {
            if (transaction.getValue() > higTransaction.getValue()) {
                higTransaction = transaction;
            }
        }
        return higTransaction;
    }

    /**
     * Find all transactions in the year 2016 and sort them by value (high to small).",
     *
     * @return
     */
    private List<Transaction> tansactionOf2016() {
        final Long epoch2016 = get2016Epoch();
        final List<Transaction> allTransactions = TRANS_CLIENT.getTransactions();
        final List<Transaction> sorted2016Trans = new ArrayList<>();
        allTransactions.stream().filter(p -> p.getTimestamp() >= epoch2016).sorted().forEach(sorted2016Trans::add);
        return sorted2016Trans;
    }


    /**
     * Find the average of transactions values from the traders living in Beijing
     *
     * @return
     */
    private double getAvgTransantionForBeijing() {
        // Create a cache of Beijing trader for easy lookup
        final List<Trader> allTraders = TRADERS_CLIENT.getTraders();
        final Set<String> beijingTradersId = new HashSet<>();
        allTraders.stream().filter(p -> p.getCity().equalsIgnoreCase("Beijing"))
                .forEach(p -> beijingTradersId.add(p.getId()));

        final List<Transaction> allTransactions = TRANS_CLIENT.getTransactions();
        Double totalValue = 0d;
        int count = 0;
        for (final Transaction tran : allTransactions) {
            // Sum up all Beijing transactions
            if (beijingTradersId.contains(tran.getTraderId())) {
                totalValue += tran.getValue();
                count++;
            }
        }
        return count == 0 ? -1d : totalValue / count;
    }

    /**
     * Get EPOCH for 2016
     *
     * @return
     */
    private static long get2016Epoch() {
        long epoch = 1451606400l;
        try {
            final SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
            epoch = df.parse("Jan 01 2016 00:00:00.000 UTC").getTime();

        } catch (final ParseException e) {}
        return epoch;
    }


    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Challenge challenge = new Challenge();
        System.out.println("Sorted traders from Singapore ->" + challenge.getSGPTraders());
        System.out.println("Transaction with the highest value ->" + challenge.findHighestValTransaction());
        System.out.println("All sorted transactions in the year 2016 ->" + challenge.tansactionOf2016());
        System.out.println("Average of transactions values from the traders living in Beijing ->"
                + challenge.getAvgTransantionForBeijing());
    }

}
