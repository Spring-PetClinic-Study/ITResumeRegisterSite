package kr.co.itresumeregistersite.domain.resume.controller;

import kr.co.itresumeregistersite.domain.resume.dto.EditResumeDto;
import kr.co.itresumeregistersite.domain.resume.dto.RegisterResumeDto;
import kr.co.itresumeregistersite.domain.resume.dto.ResumeInfoDto;
import kr.co.itresumeregistersite.domain.resume.entity.Resume;
import kr.co.itresumeregistersite.domain.resume.service.ResumeService;
import kr.co.itresumeregistersite.global.error.response.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    // 이력서 작성
    @PostMapping()
    public ResponseFormat registerResume(@RequestBody @Valid RegisterResumeDto registerResumeDto) {
        resumeService.registerResume(registerResumeDto);
        return ResponseFormat.ok();
    }

    // 이력서 전체 목록 조회
    @GetMapping("/findAll")
    public ResponseFormat<List<ResumeInfoDto>> findAllResumeInfo() {
        return ResponseFormat.ok(resumeService.findAllResumeInfo());
    }

    // 특정 이력서 조회
    @GetMapping()
    public ResponseFormat<ResumeInfoDto> findResumeInfo(@RequestParam @Valid Long resumeId) {
        return ResponseFormat.ok(resumeService.findResumeInfo(resumeId));
    }

    // 이력서 수정
    @PutMapping()
    public ResponseFormat editResume(@RequestBody @Valid EditResumeDto editResumeDto) {
        resumeService.editResume(editResumeDto);
        return ResponseFormat.ok();
    }

    // 이력서 삭제
    @DeleteMapping()
    public ResponseFormat deleteResume(@RequestParam @Valid Long resumeId) {
       resumeService.deleteResume(resumeId);
       return ResponseFormat.ok();
    }
}
