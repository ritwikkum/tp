package com.ritwik.tp.traderapp.api;

import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ritwik.tp.traderapp.dto.Transaction;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author ritwik.kumar
 *
 */
@Slf4j
public class TransactionsAPIClient extends AbstractAPIClient {
    private static TransactionsAPIClient instance;
    private List<Transaction> transactions;

    /**
     *
     * @return
     */
    public static TransactionsAPIClient getInstance() {
        if (instance == null) {
            synchronized (TradersAPIClient.class) {
                if (instance == null) {
                    instance = new TransactionsAPIClient();
                }
            }
        }
        return instance;
    }

    /**
     *
     */
    private TransactionsAPIClient() {
        super(BASE_URL + "transactions");
    }


    /**
     * Fetch List of all Transactions
     *
     * @return
     */
    private List<Transaction> fetchTransactionsList() {
        log.debug("getTransactionsList");
        try {
            final String transactionJson = httpGetToAPI(apiEndpoint);
            final List<Transaction> transactions =
                    GSON.fromJson(transactionJson, new TypeToken<List<Transaction>>() {}.getType());
            return transactions;
        } catch (final Exception exp) {
            log.error("Error in getTransactionsList", exp);
            return null;
        }
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = fetchTransactionsList();
        }
        return transactions;
    }

}
