package kr.co.itresumeregistersite.domain.resume.repository;

import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
