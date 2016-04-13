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
public class Trader {
    private String id;
    private String name;
    private String city;
}
