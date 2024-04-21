package com.stepup.MmlnTask_04.checkers;

import com.stepup.MmlnTask_04.interfaces.Checker02AppTypeable;
import com.stepup.MmlnTask_04.loggers.LogTransformation;
import org.springframework.stereotype.Component;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.util.List;

@Component
public class Checker02AppType implements Checker02AppTypeable {
    public String checkStrType(String applType) {
        if (applType == null)
            applType = "";
        if (!applType.equals("web") && !applType.equals("mobile"))
            return "other:" + applType;
        return applType;
    }

    @LogTransformation("LogTransformation.log")
    @Override
    public List<DataFromFiles> checkType(List<DataFromFiles> datas) {
        datas.stream().peek(x-> x.setAppType(checkStrType(x.getAppType()))).toList();
        return datas;
    }

}
