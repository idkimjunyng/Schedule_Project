package org.example.schedule_project.dto;

import lombok.Getter;
import org.example.schedule_project.entity.Member;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String name;
    private final String email;
    private final String password;

    public MemberResponseDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }



    public static MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(member.getId(), member.getName(), member.getEmail(), member.getPassword());
    }
}
