package test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long>  {
	AuthToken findByValue(String value);
}
