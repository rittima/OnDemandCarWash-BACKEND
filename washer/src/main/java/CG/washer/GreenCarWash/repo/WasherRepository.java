package CG.washer.GreenCarWash.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import CG.washer.GreenCarWash.model.WasherProfile;

 

@Repository
public interface WasherRepository extends MongoRepository<WasherProfile,String>{
}


 