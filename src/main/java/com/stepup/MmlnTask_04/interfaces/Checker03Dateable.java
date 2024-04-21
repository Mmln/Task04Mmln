package com.stepup.MmlnTask_04.interfaces;

import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.IOException;
import java.util.List;

public interface Checker03Dateable {
    public List<DataFromFiles> checkDate(List<DataFromFiles> datas) throws IOException;
}
