package io.ramoura.howtouse.springboot.mongodb.repository;

import io.ramoura.howtouse.springboot.mongodb.repository.entity.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<Asset, String> {
}
