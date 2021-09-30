package com.example.cicd.repository;

import com.example.cicd.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, String>{
    Member save(Member member);

    Member findById(Long id);

    List<Member> findAll();
}
