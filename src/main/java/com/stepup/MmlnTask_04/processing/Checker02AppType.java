package com.stepup.MmlnTask_04.processing;

import com.stepup.MmlnTask_04.loggers.LogTransformation;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.IOException;
import java.util.List;

@Component("checkapptype")
@Order(2)
@LogTransformation("LogTransformation.log")
public class Checker02AppType implements ConveyerDataProcessingAble {
    public String checkStrType(String applType) {
        if (applType == null)
            applType = "";
        if (!applType.equals("web") && !applType.equals("mobile"))
            return "other:" + applType;
        return applType;
    }

    @Override
    public List<DataFromFiles> process(List<DataFromFiles> datas) throws IOException {
        System.out.println("Checker02AppType called");
        datas.stream().peek(x-> x.setAppType(checkStrType(x.getAppType()))).toList();
        return datas;
    }

}
