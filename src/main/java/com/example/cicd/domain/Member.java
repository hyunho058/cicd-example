package com.example.cicd.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;


    /**
     * 생성 메서드
     *
     * @author hyunho
     * @since 2021/09/30
    **/
    public static  Member createMember(String name, int age){
        Member member = new Member();
        member.setName(name);
        member.setAge(age);

        return member;
    }


    public void changeName(String name){
        this.name = name;
    }
}
