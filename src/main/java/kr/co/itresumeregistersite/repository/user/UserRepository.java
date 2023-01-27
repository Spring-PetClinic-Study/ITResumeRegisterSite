package kr.co.itresumeregistersite.repository.user;

import kr.co.itresumeregistersite.domain.entity.user.User;
import kr.co.itresumeregistersite.domain.entity.user.dto.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdentity(String identity);

    User findByIdentityAndPassword(String identity, String password);

    List<UserInfoDto> findUserListBy();
}
