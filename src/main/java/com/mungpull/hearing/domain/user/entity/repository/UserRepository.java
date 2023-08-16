package com.mungpull.hearing.domain.user.entity.repository;

import com.mungpull.hearing.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
