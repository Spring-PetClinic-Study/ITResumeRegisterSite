package kr.co.itresumeregistersite.repository;

import kr.co.itresumeregistersite.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
