package com.ritwik.tp.traderapp.dto;

import org.apache.commons.lang3.ObjectUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author ritwik.kumar
 *
 */
@Data
@AllArgsConstructor
@ToString
public class Transaction implements Comparable<Transaction> {
    private final String traderId;
    private final Double value;
    private final Long timestamp;

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Transaction other) {
        if (other == null) {
            return -1;
        }
        return ObjectUtils.compare(value, other.value);
    }
}
