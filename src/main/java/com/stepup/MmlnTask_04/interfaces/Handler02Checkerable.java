package com.stepup.MmlnTask_04.interfaces;

import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.IOException;
import java.util.List;

public interface Handler02Checkerable {
    public List<DataFromFiles> process(List<DataFromFiles> datas) throws IOException;
}
