package mate.academy.bootmongodocker.repository;

import java.util.List;
import mate.academy.bootmongodocker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    // Example of projection
    @Query(value="{}", fields="{name : 1, _id : 0}")
    List<User> findNameAndExcludeId();
}
