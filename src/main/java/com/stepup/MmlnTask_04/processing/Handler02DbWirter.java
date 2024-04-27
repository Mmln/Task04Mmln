package com.stepup.MmlnTask_04.processing;

import com.stepup.MmlnTask_04.repositories.LoginsRepository;
import com.stepup.MmlnTask_04.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.stepup.MmlnTask_04.entities.Logins;
import com.stepup.MmlnTask_04.entities.Users;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@Order(4)
public class Handler02DbWirter  implements ConveyerDataProcessingAble {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    public LoginsRepository loginsRepository;

    public Handler02DbWirter(UsersRepository usersRepository, LoginsRepository loginsRepository) {
        this.usersRepository = usersRepository;
        this.loginsRepository = loginsRepository;
    }

    @Override
    @Transactional
    public List<DataFromFiles> process(List<DataFromFiles> datas) {
        System.out.println("Handler02DbWirter called");
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
        return datas;
    }
}
