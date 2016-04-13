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

    /**
     *
     */
    public TransactionsAPIClient() {
        super(BASE_URL + "transactions");
    }


    /**
     * Fetch List of all Transactions
     *
     * @return
     */
    public List<Transaction> getTransactionsList() {
        log.debug("getTransactionsList");
        String transactionJson = null;
        try {
            transactionJson = httpGetToAPI(apiEndpoint);
        } catch (final Exception exp) {
            log.error("Error in getTransactionsList", exp);
            return null;
        }
        final List<Transaction> transactions =
                GSON.fromJson(transactionJson, new TypeToken<List<Transaction>>() {}.getType());
        return transactions;
    }

}
