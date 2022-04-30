package appgonza.application.repositories;

import appgonza.application.dtos.UserDto;
import appgonza.application.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {

    @Query("{dni:?0}")
    Optional<User> findByDni(String dni);
}
