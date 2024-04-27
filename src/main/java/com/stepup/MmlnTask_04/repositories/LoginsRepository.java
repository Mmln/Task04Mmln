package com.stepup.MmlnTask_04.repositories;

import com.stepup.MmlnTask_04.entities.Logins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginsRepository extends JpaRepository<Logins, Integer> {

}
