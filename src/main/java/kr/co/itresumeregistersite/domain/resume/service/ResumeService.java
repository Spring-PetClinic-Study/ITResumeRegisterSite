package kr.co.itresumeregistersite.domain.resume.service;

import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import kr.co.itresumeregistersite.domain.resume.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    // TODO : 이력서 작성
    public void registerResume(RegisterResumeDto registerResumeDto) {
        Resume resume = Resume.of(registerResumeDto);
        resumeRepository.save(resume);
    }

    // TODO : 이력서 조회

    // TODO : 이력서 수정

    // TODO : 이력서 삭제
}
