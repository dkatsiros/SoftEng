package test;

import org.springframework.data.repository.CrudRepository;
import test.AuthToken;

public interface AuthTokenRepository extends CrudRepository<AuthToken, Integer>  {

}
