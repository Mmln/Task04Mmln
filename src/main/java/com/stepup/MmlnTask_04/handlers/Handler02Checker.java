package com.stepup.MmlnTask_04.handlers;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.interfaces.Checker01Fioable;
import com.stepup.MmlnTask_04.interfaces.Checker02AppTypeable;
import com.stepup.MmlnTask_04.interfaces.Checker03Dateable;
import com.stepup.MmlnTask_04.interfaces.Handler02Checkerable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import static com.stepup.MmlnTask_04.loggers.LogDebug.debugSout;

@Component
public class Handler02Checker implements Handler02Checkerable {
    private List<DataFromFiles> dataFromFiles;
    private final Checker01Fioable checkerFio;
    private final Checker02AppTypeable checkerAppType;
    private final Checker03Dateable checkerDate;

    @Autowired
    public Handler02Checker(
              Checker01Fioable checkerFio
            , Checker02AppTypeable checkerAppType
            , Checker03Dateable checkerDate
    )
    {
        this.checkerFio = checkerFio;
        this.checkerAppType = checkerAppType;
        this.checkerDate = checkerDate;
    }
    public List<DataFromFiles> process(List<DataFromFiles> datas) throws IOException {
        datas = checkerFio.checkFio(datas);
        System.out.println("\nDataFromFile after cheking fio list started...");
        debugSout(datas);
        System.out.println("DataFromFile after cheking fio list finished...\n");

        datas = checkerAppType.checkType(datas);
        System.out.println("\nDataFromFile after cheking apptype list started...");
        debugSout(datas);
        System.out.println("DataFromFile after cheking apptype list finished...\n");

        datas = checkerDate.checkDate(datas);
        System.out.println("\nDataFromFile after cheking dates list started...");
        debugSout(datas);
        System.out.println("DataFromFile after cheking dates list finished...\n");

        return datas;

    }

}
