package app.models;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository<User,String > {
    User findByUsername(String username);
}
