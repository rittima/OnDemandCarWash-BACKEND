package CG.washer.GreenCarWash.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import CG.washer.GreenCarWash.model.User1;

@Repository
public interface UserRepo  extends MongoRepository<User1, String>
{
	User1 findByUsername(String username);

Boolean existsByUsername(String username);
 
}
