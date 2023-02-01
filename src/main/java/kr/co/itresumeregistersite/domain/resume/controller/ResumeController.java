package kr.co.itresumeregistersite.domain.resume.controller;

import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import kr.co.itresumeregistersite.domain.resume.service.ResumeService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseFormat.ok();
    }

    // 이력서 전체 목록 조회
    @GetMapping
    public ResponseFormat<List<Resume>> findAllResumeInfo() {
        return ResponseFormat.ok(resumeService.findAllResumeInfo());
    }

    // 특정 이력서 조회
    @GetMapping("/company")
    public ResponseFormat<List<Resume>> findResumeInfo(String companyName) {
        return ResponseFormat.ok(resumeService.findResumeInfo(companyName));
    }

    // TODO : 이력서 수정

    // TODO : 이력서 삭제
}
