package com.stepup.MmlnTask_04.repositories;

import com.stepup.MmlnTask_04.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
