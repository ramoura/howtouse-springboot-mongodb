package io.ramoura.howtouse.springboot.mongodb.controller;

import io.ramoura.howtouse.springboot.mongodb.UnitTestWithMockito;
import io.ramoura.howtouse.springboot.mongodb.model.Asset;
import io.ramoura.howtouse.springboot.mongodb.usecase.CreateAsset;
import io.ramoura.howtouse.springboot.mongodb.usecase.GetAsset;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

class AssetControllerTest implements UnitTestWithMockito {

    @InjectMocks
    private AssetController assetController;
    @Mock
    private CreateAsset createAsset;
    @Mock
    private GetAsset getAsset;


    @Test
    void post_success() {
        Asset body = Asset.builder().build();
        Mockito.when(createAsset.create(body)).thenReturn("That_ID");

        ResponseEntity<Void> post = assetController.post(body, UriComponentsBuilder.newInstance());

        Assertions.assertThat(post.getStatusCode())
            .isEqualTo(HttpStatus.CREATED);

        String path = post.getHeaders().getLocation().getPath();
        Assertions.assertThat(path).isEqualTo("/asset/That_ID");
    }

    @Test
    void get_WhenFoundAsset() {
        String assetId = "that_id";
        Asset build = Asset.builder()
            .ticker("my_ticker")
            .build();
        Mockito.when(getAsset.getBy(assetId)).thenReturn(Optional.of(build));

        ResponseEntity<Asset> assetResponseEntity = assetController.get(assetId);

        Assertions.assertThat(assetResponseEntity.getStatusCode())
            .isEqualTo(HttpStatus.OK);
        Asset bodyResponse = assetResponseEntity.getBody();
        Assertions.assertThat(bodyResponse.getTicker()).isEqualTo("my_ticker");
    }

    @Test
    void get_WhenNotFoundAsset() {
        String assetId = "this_id";
        Mockito.when(getAsset.getBy(assetId)).thenReturn(Optional.empty());

        ResponseEntity<Asset> assetResponseEntity = assetController.get(assetId);

        Assertions.assertThat(assetResponseEntity.getStatusCode())
            .isEqualTo(HttpStatus.NOT_FOUND);
        Assertions.assertThat(assetResponseEntity.getBody())
            .isNull();
    }

}
