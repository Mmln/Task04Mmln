package com.stepup.MmlnTask_04.processing;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.loggers.LogTransformation;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component("checkFio")
@Order(2)
public class Checker01Fio implements ConveyerDataProcessingAble {
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
    public List<DataFromFiles> processing(List<DataFromFiles> datas) throws IOException {
        System.out.println("Checker01Fio called");
        datas.stream().peek(x-> x.setFio(checkStrFio(x.getFio()))).collect(Collectors.toList());
        return datas;
    }
}
