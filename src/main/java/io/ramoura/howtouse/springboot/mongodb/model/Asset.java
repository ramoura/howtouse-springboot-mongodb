package io.ramoura.howtouse.springboot.mongodb.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Asset {
    private String ticker;

    private String shortName;

    private String longName;

    private String currencyCode;

}
