package mate.academy.bootmongodocker.repository;

import mate.academy.bootmongodocker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
