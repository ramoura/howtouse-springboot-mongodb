package io.ramoura.howtouse.springboot.mongodb.repository.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asset")
@Getter
@Builder
public class Asset {
    @Id
    private String id;
    private String ticker;

    private String shortName;

    private String longName;

    private String currencyCode;

}
