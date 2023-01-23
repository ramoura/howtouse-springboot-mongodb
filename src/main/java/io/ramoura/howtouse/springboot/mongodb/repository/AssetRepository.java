package io.ramoura.howtouse.springboot.mongodb.repository;

import io.ramoura.howtouse.springboot.mongodb.repository.entity.AssetEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<AssetEntity, String> {
}
