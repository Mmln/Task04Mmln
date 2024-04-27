package com.stepup.MmlnTask_04.processing;

import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.IOException;
import java.util.List;

public interface ConveyerDataProcessingAble {
    List<DataFromFiles> processing(List<DataFromFiles> datas) throws IOException;

}
