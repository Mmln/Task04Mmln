package com.stepup.MmlnTask_04.services;

import com.stepup.MmlnTask_04.entities.Users;
import com.stepup.MmlnTask_04.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

   @Autowired
   UsersRepository repo;
//    Users newUsers(String username, String fio)
//    {
//        Users a = new Users(username, fio);
//        repo.save(a);
//        return a;
//    }

    public Users saveUsers(Users a)
    {
        repo.save(a);
        return  a;
    }

//    public Optional<Users> getUsersbyId(Integer id)
//    {
//        return repo.findById(id);
//
//    }

//    List<Users> getAllUsers()
//    {
//        return (List<Users>) repo.findAll();
//    }
}
