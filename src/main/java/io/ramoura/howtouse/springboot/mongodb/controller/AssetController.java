package io.ramoura.howtouse.springboot.mongodb.controller;

import io.ramoura.howtouse.springboot.mongodb.model.Asset;
import io.ramoura.howtouse.springboot.mongodb.usecase.CreateAsset;
import io.ramoura.howtouse.springboot.mongodb.usecase.GetAsset;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/asset")
@RequiredArgsConstructor
public class AssetController {

    private final CreateAsset createAsset;
    private final GetAsset getAsset;

    @PostMapping()
    public ResponseEntity<Void> post(@RequestBody Asset assetBody, UriComponentsBuilder uriBuilder) {
        String id = createAsset.create(assetBody);
        URI uri = uriBuilder.path("/asset/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{assetId}")
    public ResponseEntity<Asset> get(@PathVariable String assetId) {
        Optional<Asset> asset = getAsset.getBy(assetId);
        return of(asset);
    }

    public static <T> ResponseEntity<T> of(Optional<T> body) {
        return body.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
