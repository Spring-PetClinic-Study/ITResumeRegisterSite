package kr.co.itresumeregistersite.repository.user;

import kr.co.itresumeregistersite.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdentity(String identity);
}
