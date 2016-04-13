/**
 * Copyright (c) 2015. InMobi, All Rights Reserved.
 */
package com.ritwik.tp.traderapp.dto;

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
public class Transaction {
    private String traderId;
    private Double value;
    private Long timestamp;
}
