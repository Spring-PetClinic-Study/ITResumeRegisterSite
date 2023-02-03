package kr.co.itresumeregistersite.domain.resume.service;

import kr.co.itresumeregistersite.domain.resume.dto.EditResumeDto;
import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.resume.dto.ResumeInfoDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import kr.co.itresumeregistersite.domain.resume.repository.ResumeRepository;
import kr.co.itresumeregistersite.global.error.exception.resume.NoResumeRequiredEntriesException;
import kr.co.itresumeregistersite.global.error.exception.resume.NotFoundResumeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    // 이력서 작성
    @Transactional
    public void registerResume(RegisterResumeDto registerResumeDto) {
        invalidResumeEntries(registerResumeDto.getSchoolName(), registerResumeDto.getProfile());
        Resume resume = Resume.of(registerResumeDto);
        resumeRepository.save(resume);
    }

    // 이력서 전체 목록 조회
    @Transactional(readOnly = true)
    public List<ResumeInfoDto> findAllResumeInfo() {
        return resumeRepository.findResumeListBy();
    }

    // 특정 이력서 조회
    @Transactional(readOnly = true)
    public ResumeInfoDto findResumeInfo(Long resumeId) {
        Resume resume = resumeRepository.findByResumeId(resumeId)
                .orElseThrow(NotFoundResumeException::new);

        return Resume.of(resume);
    }

    // 이력서 수정
    @Transactional
    public void editResume(EditResumeDto editResumeDto) {
        Resume resume = resumeRepository.findByResumeId(editResumeDto.getResumeId())
                        .orElseThrow(NotFoundResumeException::new);
        resume.edit(editResumeDto.getSchoolName(),
                editResumeDto.getMajor(),
                editResumeDto.getMinor(),
                editResumeDto.getProfile(),
                editResumeDto.getModifiedDate());

        resumeRepository.save(resume);
    }

    // 이력서 삭제
    @Transactional
    public void deleteResume(Long resumeId) {
        resumeRepository.deleteById(resumeId);
    }



    // 이력서 필수항목 미입력 시 예외처리
    private void invalidResumeEntries(String schoolName, String profile) {
        if (schoolName == null) {
            throw new NoResumeRequiredEntriesException();
        }
        if (profile == null) {
            throw new NoResumeRequiredEntriesException();
        }
    }

    // 작성된 이력서가 없을 경우 예외처리
    private void noResumeHasBeenCompleted(Long resumeId) {
        if (!resumeRepository.existsByResumeId(resumeId)) {
            throw new NotFoundResumeException();
        }
    }
}
