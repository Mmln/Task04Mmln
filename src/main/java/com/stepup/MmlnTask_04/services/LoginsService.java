package com.stepup.MmlnTask_04.services;

import com.stepup.MmlnTask_04.entities.Logins;
import com.stepup.MmlnTask_04.entities.Users;
import com.stepup.MmlnTask_04.repositories.LoginsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoginsService {

   @Autowired
   LoginsRepository repo;
    Logins newLogins(LocalDateTime access_date, Users user_id, String application)
    {
        Logins a = new Logins(access_date, user_id, application);
        repo.save(a);
        return a;
    }

    public Logins saveLogins(Logins a)
    {
        repo.save(a);
        return  a;
    }

    public Optional<Logins> getLoginsbyId(Integer id)
    {
        return repo.findById(id);

    }

    List<Logins> getAllLogins()
    {
        return (List<Logins>) repo.findAll();
    }
}
