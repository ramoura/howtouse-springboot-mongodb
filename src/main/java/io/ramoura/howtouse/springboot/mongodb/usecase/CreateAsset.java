package io.ramoura.howtouse.springboot.mongodb.usecase;

import io.ramoura.howtouse.springboot.mongodb.model.Asset;
import io.ramoura.howtouse.springboot.mongodb.repository.AssetRepository;
import io.ramoura.howtouse.springboot.mongodb.repository.entity.AssetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAsset {

    private final AssetRepository assetRepository;
    public String create(Asset assetBody) {
        AssetEntity entity = AssetEntity.builder()
            .ticker(assetBody.getTicker())
            .currencyCode(assetBody.getCurrencyCode())
            .shortName(assetBody.getShortName())
            .longName(assetBody.getLongName())
            .build();
        return assetRepository.save(entity).getId();
    }
}
