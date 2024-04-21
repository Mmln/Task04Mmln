package com.stepup.MmlnTask_04.checkers;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.interfaces.Checker01Fioable;
import com.stepup.MmlnTask_04.loggers.LogTransformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Checker01Fio implements Checker01Fioable {
    public String checkStrFio(String fio) {
        String[] arrStr = fio.split(" ");
        StringBuilder strRes = new StringBuilder();
        for (String s : arrStr) {
            String addStr = s.trim();
            if (!addStr.isEmpty())
                strRes.append(" ")
                .append(addStr.substring(0, 1)
                .toUpperCase())
                .append(addStr.substring(1).toLowerCase());
        }
        return strRes.toString().trim();
    }

    @LogTransformation("LogTransformation.log")
    @Override
    public List<DataFromFiles> checkFio(List<DataFromFiles> datas) {
        datas.stream().peek(x-> x.setFio(checkStrFio(x.getFio()))).collect(Collectors.toList());
        return datas;
    }
}
