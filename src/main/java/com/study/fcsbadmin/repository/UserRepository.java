package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}
