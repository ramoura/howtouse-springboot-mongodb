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

class CreateAssetTest implements UnitTestWithMockito {

    @InjectMocks
    private CreateAsset createAsset;
    @Mock
    private AssetRepository assetRepository;

    @Test
    void create_success() {
        AssetEntity entity = AssetEntity.builder()
            .id("that_id").build();
        Mockito.when(assetRepository.save(Mockito.any())).thenReturn(entity);
        Asset build = Asset.builder().build();

        String entityId = createAsset.create(build);

        Assertions.assertThat(entityId).isEqualTo("that_id");
    }
}
