package com.stepup.MmlnTask_04.processing;

import com.stepup.MmlnTask_04.loggers.LogTransformation;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.IOException;
import java.util.List;

@Component("checkapptype")
@Order(3)
public class Checker02AppType implements ConveyerDataProcessingAble {
    public String checkStrType(String applType) {
        if (applType == null)
            applType = "";
        if (!applType.equals("web") && !applType.equals("mobile"))
            return "other:" + applType;
        return applType;
    }

    @LogTransformation("LogTransformation.log")
    @Override
    public List<DataFromFiles> processing(List<DataFromFiles> datas) throws IOException {
        System.out.println("Checker02AppType called");
        datas.stream().peek(x-> x.setAppType(checkStrType(x.getAppType()))).toList();
        return datas;
    }

}
