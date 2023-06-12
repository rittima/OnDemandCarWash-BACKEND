package CG.washer.GreenCarWash.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import CG.washer.GreenCarWash.model.WashPacks;

@Repository
public interface WashPackRepo extends MongoRepository<WashPacks, String> {
}
