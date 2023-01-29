package kr.co.itresumeregistersite.domain.user.repository;

import kr.co.itresumeregistersite.domain.user.entity.User;
import kr.co.itresumeregistersite.domain.user.dto.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdentity(String identity);

    boolean existsByIdentity(String identity);

    boolean existsByPassword(String password);

    List<UserInfoDto> findUserListBy();
}
