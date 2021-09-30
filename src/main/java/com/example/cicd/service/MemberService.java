package com.example.cicd.service;

import com.example.cicd.domain.Member;
import com.example.cicd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //일기 전용에서는 readOnly = true 를 해주면 트렌젝션이 최적화 해서 조회를 한다(성능 향상)
@RequiredArgsConstructor //final 이 있는 필드를 가지고 생성자를 만들어줌
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public void memberUpdate(Long id, String name) {
        Member member = memberRepository.findById(id);
        member.changeName(name);
    }

}
