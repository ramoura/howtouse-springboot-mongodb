package io.ramoura.howtouse.springboot.mongodb.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Asset {
    private String ticker;

    private String shortName;

    private String longName;

    private String currencyCode;

}
