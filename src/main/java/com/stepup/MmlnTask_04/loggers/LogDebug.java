package com.stepup.MmlnTask_04.loggers;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.interfaces.LogDebugable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LogDebug implements LogDebugable {

    private static boolean debug = true;

    public static void debugSout(List<DataFromFiles> datas){
        if(debug) System.out.print("LogDebug\n" + StringUtils.join(datas, ""));
    }

}
