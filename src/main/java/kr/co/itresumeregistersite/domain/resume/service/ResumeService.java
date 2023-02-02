package kr.co.itresumeregistersite.domain.resume.service;

import kr.co.itresumeregistersite.domain.resume.dto.EditResumeDto;
import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import kr.co.itresumeregistersite.domain.resume.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    // 이력서 작성
    public void registerResume(RegisterResumeDto registerResumeDto) {
        Resume resume = Resume.of(registerResumeDto);
        resumeRepository.save(resume);
    }

    // 이력서 전체 목록 조회
    public List<Resume> findAllResumeInfo() {
        return resumeRepository.findAll();
    }

    // 특정 이력서 조회
    public Optional<Resume> findResumeInfo(Long resumeId) {
        Optional<Resume> resume = resumeRepository.findByResumeId(resumeId);
        return resume;
    }

    // 이력서 수정
    public void editResume(EditResumeDto editResumeDto) {
        Optional<Resume> resume = resumeRepository.findByResumeId(editResumeDto.getResumeId());
        resume.get().edit(editResumeDto.getSchoolName(),
                editResumeDto.getMajor(),
                editResumeDto.getMinor(),
                editResumeDto.getProfile(),
                editResumeDto.getModifiedDate());

        resumeRepository.save(resume.get());
    }

    // TODO : 이력서 삭제
}
