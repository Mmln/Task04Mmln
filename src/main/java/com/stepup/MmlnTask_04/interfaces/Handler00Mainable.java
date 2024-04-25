package com.stepup.MmlnTask_04.interfaces;

import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.IOException;
import java.util.List;

public interface Handler00Mainable {
    public  void process() throws IOException;
    public List<DataFromFiles> getDataFromFiles();
}
