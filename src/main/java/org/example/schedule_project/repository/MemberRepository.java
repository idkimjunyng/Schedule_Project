package org.example.schedule_project.repository;

import org.example.schedule_project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByEmail(String email);

    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    default Member findMemberByMemberEmailOrElseThrow(String member_email) {
        return findMemberByEmail(member_email).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + member_email));
    }

}
