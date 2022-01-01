package com.springboot.restful.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.restful.webservice.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
