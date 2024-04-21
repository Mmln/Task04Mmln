package com.stepup.MmlnTask_04.loggers;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.interfaces.LogDebugable;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LogDebug implements LogDebugable {
    private final static boolean debug = false;

    public static void debugSout(List<DataFromFiles> datas){
        if(debug) System.out.print(StringUtils.join(datas, ""));
    }

}
