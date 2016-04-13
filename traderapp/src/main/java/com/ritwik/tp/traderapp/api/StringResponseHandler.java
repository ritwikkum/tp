/**
 * 
 */
package com.ritwik.tp.traderapp.api;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;

/**
 * @author ritwik.kumar
 * 
 */
public class StringResponseHandler implements ResponseHandler<String> {

  @Override
  public String handleResponse(final HttpResponse httpResp) throws ClientProtocolException, IOException {
    final StatusLine statusLine = httpResp.getStatusLine();
    final HttpEntity entity = httpResp.getEntity();
    if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
      throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
    }
    if (entity == null) {
      throw new ClientProtocolException("Response contains no content");
    }

    return IOUtils.toString(entity.getContent());
  }

}
