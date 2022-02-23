package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
    Member findByUserId(String userId);

    Member findByUserIdAndPassword(String userId, String password);
}
