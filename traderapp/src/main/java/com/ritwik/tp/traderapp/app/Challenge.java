/**
 * Copyright (c) 2015. InMobi, All Rights Reserved.
 */
package com.ritwik.tp.traderapp.app;

import com.ritwik.tp.traderapp.api.TradersAPIClient;
import com.ritwik.tp.traderapp.api.TransactionsAPIClient;

/**
 * @author ritwik.kumar
 *
 */
public class Challenge {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final TradersAPIClient tradersClient = new TradersAPIClient();
        final TransactionsAPIClient transactionsClient = new TransactionsAPIClient();
        System.out.println(tradersClient.getTradersList());
        System.out.println(transactionsClient.getTransactionsList());
    }

}
