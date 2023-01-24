package io.ramoura.howtouse.springboot.mongodb.controller;

import io.ramoura.howtouse.springboot.mongodb.model.Asset;
import io.ramoura.howtouse.springboot.mongodb.usecase.CreateAsset;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AssetController {

    private final CreateAsset createAsset;

    @PostMapping("/asset")
    public ResponseEntity post(@RequestBody Asset assetBody) {
        createAsset.create(assetBody);
        return ResponseEntity.created(URI.create("/get")).build();
    }

}
