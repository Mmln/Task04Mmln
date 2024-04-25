package com.stepup.MmlnTask_04.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataFromFiles {
    private String username;
    private String fio;
    private String accessDate ;
    private String appType;
    private String fileName;

    @Override
    public String toString() {
        return "DataFromFiles={" + "username=" + username +
                ",fio=" + fio +
                ",accessDate=" + accessDate +
                ",appType=" + appType +
                ",filename=" + fileName + "}\n";
    }
}
