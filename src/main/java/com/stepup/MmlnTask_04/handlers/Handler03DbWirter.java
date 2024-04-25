package com.stepup.MmlnTask_04.handlers;

import com.stepup.MmlnTask_04.interfaces.Handler03DbWirterable;
import com.stepup.MmlnTask_04.interfaces.LoginsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.stepup.MmlnTask_04.entities.Logins;
import com.stepup.MmlnTask_04.entities.Users;
import com.stepup.MmlnTask_04.interfaces.UsersRepository;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Component
public class Handler03DbWirter implements Handler03DbWirterable {
    private final UsersRepository usersRepository;
    private final LoginsRepository loginsRepository;

    @Autowired
    public Handler03DbWirter(UsersRepository usersRepository, LoginsRepository loginsRepository) {
        this.usersRepository = usersRepository;
        this.loginsRepository = loginsRepository;
    }

    @Override
    @Transactional
    public void writeDb(List<DataFromFiles> datas) {
        datas.sort((o1, o2) -> (o1.getUsername() + o2.getFio()).compareTo(o2.getUsername() + o2.getFio()));
        String keyCmp = "";
        Users usr = new Users();
        for (DataFromFiles d : datas) {
            if (!keyCmp.equals(d.getUsername() + d.getFio())){
                keyCmp = d.getUsername() + d.getFio();
                usr = new Users();
                usr.setUsername(d.getUsername());
                usr.setFio(d.getFio());
                usersRepository.save(usr);
            }
            Logins log = new Logins();
            log.setApplication(d.getAppType());
            log.setAccessDate(d.getAccessDate());
            log.setUser_id(usr);
            loginsRepository.save(log);
        }
    }




}
