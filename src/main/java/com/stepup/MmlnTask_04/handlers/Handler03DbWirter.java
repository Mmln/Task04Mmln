package com.stepup.MmlnTask_04.handlers;

import com.stepup.MmlnTask_04.interfaces.Handler03DbWirterable;
import com.stepup.MmlnTask_04.interfaces.LoginsRepoable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.stepup.MmlnTask_04.entities.Logins;
import com.stepup.MmlnTask_04.entities.Users;
import com.stepup.MmlnTask_04.interfaces.UsersRepoable;

import java.util.List;

@Component
public class Handler03DbWirter implements Handler03DbWirterable {
    private final UsersRepoable usersRepoable;
    private final LoginsRepoable loginsRepoable;

    @Autowired
    public Handler03DbWirter(UsersRepoable usersRepoable, LoginsRepoable loginsRepoable) {
        this.usersRepoable = usersRepoable;
        this.loginsRepoable = loginsRepoable;
    }

    @Override
    @Transactional
    public void writeDb(List<DataFromFiles> datas) {
        datas.sort((o1, o2) -> (o1.getUsername() + o2.getFio()).compareTo(o2.getUsername() + o2.getFio()));
        String keyCmp = "";
        Users usr = new Users();
        for (DataFromFiles m : datas) {
            if (!keyCmp.equals(m.getUsername() + m.getFio())){
                keyCmp = m.getUsername() + m.getFio();
                usr = new Users();
                usr.setUsername(m.getUsername());
                usr.setFio(m.getFio());
                usersRepoable.save(usr);
            }
            Logins log = new Logins();
            log.setApplication(m.getAppType());
            log.setAccessDate(m.getAccessDate());
            log.setUser_id(usr);
            loginsRepoable.save(log);
        }
    }




}
