package kr.co.itresumeregistersite.repository;

import kr.co.itresumeregistersite.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByIdentity(String identity);

    boolean existsByIdentity(String identity);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
