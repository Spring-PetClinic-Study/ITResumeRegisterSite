package kr.co.itresumeregistersite.repository;

import kr.co.itresumeregistersite.domain.dto.usersDto.UsersInfoDto;
import kr.co.itresumeregistersite.domain.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByIdentity(String identity);
}
