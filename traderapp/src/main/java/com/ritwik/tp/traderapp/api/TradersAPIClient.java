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

    /**
     *
     */
    public TradersAPIClient() {
        super(BASE_URL + "traders");
    }


    /**
     * Fetch List of all Traders
     *
     * @return
     */
    public List<Trader> getTradersList() {
        log.debug("getTradersList");
        String traderListJson = null;
        try {
            traderListJson = httpGetToAPI(apiEndpoint);
            log.debug(traderListJson);
        } catch (final Exception exp) {
            log.error("Error in getTradersList", exp);
            return null;
        }
        final List<Trader> traders = GSON.fromJson(traderListJson, new TypeToken<List<Trader>>() {}.getType());
        return traders;
    }

}
