package com.stepup.MmlnTask_04;

import com.stepup.MmlnTask_04.entities.DataFromFiles;
import com.stepup.MmlnTask_04.interfaces.ConveyerAble;
import com.stepup.MmlnTask_04.processing.ConveyerDataProcessingAble;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.stepup.MmlnTask_04.loggers.LogDebug.debugSout;

@Component
@AllArgsConstructor
public class Conveyer implements ConveyerAble {

    private List<DataFromFiles> dataFromFiles;

    @Autowired
    public List<ConveyerDataProcessingAble> dataProcessing;

    public void produce() throws IOException {
        dataFromFiles = new ArrayList<>();

        System.out.println("\nDataFromFile checking started...");
        for(ConveyerDataProcessingAble prc : dataProcessing){
            dataFromFiles = prc.process(dataFromFiles);
            debugSout(dataFromFiles);
        }
        System.out.println("DataFromFile checking finished...\n");

    }
    public List<DataFromFiles> getDataFromFiles() {
        return this.dataFromFiles;
    }
}
