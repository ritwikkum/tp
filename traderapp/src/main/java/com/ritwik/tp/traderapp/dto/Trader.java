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
public class Trader implements Comparable<Trader> {
    private final String id;
    private final String name;
    private final String city;

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Trader other) {
        if (other == null) {
            return -1;
        }
        return ObjectUtils.compare(name, other.name);
    }
}
