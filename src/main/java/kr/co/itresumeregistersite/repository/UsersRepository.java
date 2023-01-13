package kr.co.itresumeregistersite.repository;

import kr.co.itresumeregistersite.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByIdentity(String identity);
    Optional<Users> findByName(String name);
}
