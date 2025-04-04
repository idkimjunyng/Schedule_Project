package org.example.schedule_project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.schedule_project.dto.*;
import org.example.schedule_project.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign_up")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = memberService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> findAll() {
        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();

        return new ResponseEntity<>(memberResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable Long id, @RequestBody UpdateMemberRequestDto requestDto) {

        memberService.updateMember(id, requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemberResponseDto> deleteMember(@PathVariable Long id) {

        memberService.deleteMember(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign_in")
    public ResponseEntity<SignInResponseDto> signIn(@RequestBody SignInRequestDto requestDto, final HttpServletRequest httpServletRequest) {

        SignInResponseDto signInResponseDto = memberService.signIn(
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("member", signInResponseDto);

        return new ResponseEntity<>(signInResponseDto, HttpStatus.CREATED);
    }

}
