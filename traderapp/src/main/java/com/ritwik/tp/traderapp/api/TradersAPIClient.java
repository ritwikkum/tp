package com.ritwik.tp.traderapp.api;

import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ritwik.tp.traderapp.dto.Trader;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author ritwik.kumar
 *
 */
@Slf4j
public class TradersAPIClient extends AbstractAPIClient {
    private static TradersAPIClient instance;
    private List<Trader> traders;

    /**
     *
     * @return
     */
    public static TradersAPIClient getInstance() {
        if (instance == null) {
            synchronized (TradersAPIClient.class) {
                if (instance == null) {
                    instance = new TradersAPIClient();
                }
            }
        }
        return instance;
    }

    /**
     *
     */
    private TradersAPIClient() {
        super(BASE_URL + "traders");
    }


    /**
     * Fetch List of all Traders
     *
     * @return
     */
    private List<Trader> fetchTradersList() {
        log.debug("fetchTradersList");
        try {
            final String traderListJson = httpGetToAPI(apiEndpoint);
            log.debug(traderListJson);
            final List<Trader> traders = GSON.fromJson(traderListJson, new TypeToken<List<Trader>>() {}.getType());
            return traders;
        } catch (final Exception exp) {
            log.error("Error in fetchTradersList", exp);
            return null;
        }

    }

    /**
     * @return the traders
     */
    public List<Trader> getTraders() {
        if (traders == null) {
            traders = fetchTradersList();
        }
        return traders;
    }

}
