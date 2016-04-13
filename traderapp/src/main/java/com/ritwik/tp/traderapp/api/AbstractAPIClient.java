/**
 *
 */
package com.ritwik.tp.traderapp.api;

import static com.ritwik.tp.traderapp.api.Constants.BASE_ENDPOINT_URL;
import static com.ritwik.tp.traderapp.api.Constants.X_API_KEY;
import static com.ritwik.tp.traderapp.api.Constants.X_API_VALUE;

import org.apache.http.HttpHeaders;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ritwik.kumar
 *
 */
@Slf4j
public abstract class AbstractAPIClient {
    protected static final String APPLICATION_JSON = "application/json";
    protected static final String BASE_URL = BASE_ENDPOINT_URL;
    protected static final Gson GSON = new Gson();
    protected final String apiEndpoint;

    /**
     *
     * @param apiEndPoint
     */
    public AbstractAPIClient(final String apiEndPoint) {
        super();
        apiEndpoint = apiEndPoint;
    }


    /**
     *
     * @param getRefUrl
     * @return
     * @throws Exception
     */
    protected String httpGetToAPI(final String getRefUrl) throws Exception {
        log.debug("httpGetToAPI -> {}", getRefUrl);
        final CloseableHttpClient client = HttpClients.createDefault();
        try {
            final HttpRequestBase httpGet = new HttpGet(getRefUrl);
            addAuthHeaders(httpGet);
            final ResponseHandler<String> rh = new StringResponseHandler();
            return client.execute(httpGet, rh);
        } finally {
            client.close();
        }
    }

    /**
     *
     * @param httpBase
     */
    protected void addAuthHeaders(final HttpRequestBase httpBase) {
        httpBase.addHeader(HttpHeaders.ACCEPT, APPLICATION_JSON);
        httpBase.addHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
        httpBase.addHeader(X_API_KEY, X_API_VALUE);
    }

}
