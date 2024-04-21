package com.stepup.MmlnTask_04.interfaces;

import com.stepup.MmlnTask_04.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepoable extends JpaRepository<Users, Integer> {

}
