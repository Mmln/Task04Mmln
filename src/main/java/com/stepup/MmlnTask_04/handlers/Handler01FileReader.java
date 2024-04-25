package com.stepup.MmlnTask_04.handlers;

import com.stepup.MmlnTask_04.interfaces.Handler01FileReaderable;
import com.stepup.MmlnTask_04.loggers.LogTransformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.stepup.MmlnTask_04.entities.DataFromFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Handler01FileReader implements Handler01FileReaderable {

    @Value("${file.path}")
    private String path;

    public String getPath() {
        if (path == null)
            return new File("").getAbsolutePath();
        return path;
    }

    @LogTransformation("LogTransformation.log")
    @Override
    public List<DataFromFiles> readFromFile(String strPath) throws IOException {
        List<DataFromFiles> dataFromFiles = new ArrayList<>();
        String delimeter = ";";
        List<Path> files = Files.find(Path.of(strPath), Integer.MAX_VALUE
            , (path, attr) -> path.toString().endsWith(".txt")).toList();
        for (Path pathFile : files)
            try (Scanner scanFile = new Scanner(pathFile, StandardCharsets.UTF_8)) {
                while (scanFile.hasNextLine()) {
                    String[] strLineArr = scanFile.nextLine().split(delimeter);
                    DataFromFiles dataFF = new DataFromFiles();
                    dataFF.setFileName(pathFile.getFileName().toString());
                    for (int i = 0; i < strLineArr.length; i++) {
                        switch (i) {
                            case 0 : dataFF.setUsername(strLineArr[i]);
                                break;
                            case 1 : dataFF.setFio(strLineArr[i]);
                                break;
                            case 2 : dataFF.setAccessDate(strLineArr[i]);
                                break;
                            case 3 : dataFF.setAppType(strLineArr[i]);
                                break;
                        }
                    }
                    dataFromFiles.add(dataFF);
                }
            }
        return dataFromFiles;
    }

    public List<DataFromFiles> readFiles() throws IOException {
        String strPath = getPath();
        return readFromFile(strPath);
    }

}


