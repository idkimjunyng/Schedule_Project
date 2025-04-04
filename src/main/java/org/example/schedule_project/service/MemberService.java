package org.example.schedule_project.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.schedule_project.dto.MemberResponseDto;
import org.example.schedule_project.dto.SignInResponseDto;
import org.example.schedule_project.dto.SignUpResponseDto;
import org.example.schedule_project.entity.Member;
import org.example.schedule_project.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String name, String email, String password) {

        Member member = new Member(name, email, password);
        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getName(), savedMember.getEmail(), savedMember.getPassword());

    }

    public List<MemberResponseDto> findAll() {
        return memberRepository.findAll().stream().map(MemberResponseDto::toDto).toList();
    }

    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + "번의 member_id 를 찾을 수 없습니다.");
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getId(), findMember.getName(), findMember.getEmail(), findMember.getPassword());
    }


    public SignInResponseDto signIn(String email, String password) {

        Member member = memberRepository.findMemberByMemberEmailOrElseThrow(email);

        if(!member.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 잘못되었습니다.");
        }

        return new SignInResponseDto(member.getId(), member.getName(), member.getEmail());
    }

    @Transactional
    public void updateMember(Long id, String member_name, String member_email, String member_password) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        findMember.updateMember(member_name, member_email, member_password);
    }

    public void deleteMember(Long id) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);
        memberRepository.delete(findMember);
    }
}
