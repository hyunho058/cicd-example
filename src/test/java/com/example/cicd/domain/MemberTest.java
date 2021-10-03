package com.example.cicd.domain;

import com.example.cicd.CicdApplication;
import com.example.cicd.repository.MemberRepository;

import com.example.cicd.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("member_sign_in")
    void member_sign_in(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(CicdApplication.class);
        //give
        System.out.println("memberService = " + ac.getBean(MemberService.class));
        Member member = Member.createMember("memberA", 21);
        //when
        Long saveId = memberService.join(member);
        //then
        Assertions.assertThat(member).isEqualTo(memberRepository.findById(saveId));
    }
}