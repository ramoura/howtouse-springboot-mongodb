package io.ramoura.howtouse.springboot.mongodb.usecase;

import io.ramoura.howtouse.springboot.mongodb.model.Asset;
import io.ramoura.howtouse.springboot.mongodb.repository.AssetRepository;
import io.ramoura.howtouse.springboot.mongodb.repository.entity.AssetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetAsset {

    private final AssetRepository assetRepository;
    public Optional<Asset> getBy(String assetId) {
        Optional<AssetEntity> entity = assetRepository.findById(assetId);
        return entity.map(assetEntity -> Asset.builder()
            .ticker(assetEntity.getTicker())
            .currencyCode(assetEntity.getCurrencyCode())
            .shortName(assetEntity.getShortName())
            .longName(assetEntity.getLongName())
            .build());
    }

}
