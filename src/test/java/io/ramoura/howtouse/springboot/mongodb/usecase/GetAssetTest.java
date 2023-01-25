package io.ramoura.howtouse.springboot.mongodb.usecase;

import io.ramoura.howtouse.springboot.mongodb.UnitTestWithMockito;
import io.ramoura.howtouse.springboot.mongodb.model.Asset;
import io.ramoura.howtouse.springboot.mongodb.repository.AssetRepository;
import io.ramoura.howtouse.springboot.mongodb.repository.entity.AssetEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

class GetAssetTest implements UnitTestWithMockito {

    @InjectMocks
    private GetAsset getAsset;

    @Mock
    private AssetRepository assetRepository;

    @Test
    void getBy_ShouldReturnEmptyOptional_WhenNotFound() {
        Optional<Asset> maybe = getAsset.getBy("");
        Assertions.assertThat(maybe).isNotNull();
        Assertions.assertThat(maybe).isEmpty();
    }

    @Test
    void getBy_ShouldReturnAsset_WhenFound() {
        String thatId = "that_id";
        Mockito.when(assetRepository.findById(thatId)).thenReturn(Optional.of(AssetEntity.builder().build()));

        Optional<Asset> maybe = getAsset.getBy(thatId);
        Assertions.assertThat(maybe).isNotNull();
        Assertions.assertThat(maybe).isNotEmpty();

    }
}
