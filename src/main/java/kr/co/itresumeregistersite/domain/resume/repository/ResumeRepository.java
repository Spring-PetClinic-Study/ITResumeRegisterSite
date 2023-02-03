package kr.co.itresumeregistersite.domain.resume.repository;

import kr.co.itresumeregistersite.domain.resume.dto.ResumeInfoDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByResumeId(Long resumeId);

    List<ResumeInfoDto> findResumeListBy();

    boolean existsByResumeId(Long resumeId);
}
