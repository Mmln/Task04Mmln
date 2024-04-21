package com.stepup.MmlnTask_04.handlers;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.interfaces.Handler00Mainable;
import com.stepup.MmlnTask_04.interfaces.Handler01FileReaderable;
import com.stepup.MmlnTask_04.interfaces.Handler02Checkerable;
import com.stepup.MmlnTask_04.interfaces.Handler03DbWirterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static com.stepup.MmlnTask_04.loggers.LogDebug.debugSout;

@Component
public class Handler00Main implements Handler00Mainable {
    private List<DataFromFiles> dataFromFiles;
    private final Handler01FileReaderable fileReader;
    private final Handler02Checkerable dataChecker;
    private final Handler03DbWirterable dataWriter;

    @Autowired
    public Handler00Main(Handler01FileReaderable fileReader
            , Handler03DbWirterable dataWriter
            , Handler02Checkerable dataChecker
            )
    {
        this.fileReader = fileReader;
        this.dataWriter = dataWriter;
        this.dataChecker = dataChecker;
    }

    public  void process() throws IOException {
        String strPath = fileReader.getPath();
        dataFromFiles = fileReader.readFromFile(strPath);
        System.out.println("\nDataFromFile list started...");
        debugSout(dataFromFiles);
        System.out.println("DataFromFile list finished...\n");

        dataFromFiles = dataChecker.process(dataFromFiles);

        System.out.println("\nDataFromFile dbwriting started...");
        dataWriter.writeDb(dataFromFiles);
        System.out.println("\nDataFromFile dbwriting finished...");

    }
}
