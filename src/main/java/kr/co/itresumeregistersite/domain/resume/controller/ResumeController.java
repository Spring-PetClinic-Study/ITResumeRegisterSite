package kr.co.itresumeregistersite.domain.resume.controller;

import kr.co.itresumeregistersite.domain.resume.dto.EditResumeDto;
import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import kr.co.itresumeregistersite.domain.resume.service.ResumeService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    // 이력서 작성
    @PostMapping()
    public ResponseFormat registerResume(RegisterResumeDto registerResumeDto) {
        resumeService.registerResume(registerResumeDto);
        return ResponseFormat.ok("Your resume has been successfully registered");
    }

    // 이력서 전체 목록 조회
    @GetMapping
    public ResponseFormat<List<Resume>> findAllResumeInfo() {
        return ResponseFormat.ok(resumeService.findAllResumeInfo(),
                "Your resume has been successfully checked");
    }

    // 특정 이력서 조회
    // 학교명으로 검색할 경우 동일한 학교명을 가진 이력서들을 조회
    @GetMapping("/company")
    public ResponseFormat<Resume> findResumeInfo(Long resumeId) {
        return ResponseFormat.ok(resumeService.findResumeInfo(resumeId),
                "Your resume has been successfully checked");
    }

    // 이력서 수정
    @PutMapping()
    public ResponseFormat editResume(EditResumeDto editResumeDto) {
        resumeService.editResume(editResumeDto);
        return ResponseFormat.ok("Your resume has been successfully modified");
    }

    // TODO : 이력서 삭제
}
