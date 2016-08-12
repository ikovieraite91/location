package com.kovieraite.location.Input;

import com.kovieraite.location.Point;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class Decoder_copy {

    private String fileName;

    public Decoder_copy(String fileName){
        this.fileName=fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFileFromResources(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return file;
    }

    public List<Point> getArrayOfIntegerValuePairsFromBinaryFile(int length) {

        List<Point> coordinatePairs=new ArrayList<>();

        try {
            File file=getFileFromResources(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            for (int index1 = 0; index1 < length; index1++){
                    short x=dataInputStream.readShort();
                    short y=dataInputStream.readShort();
                    coordinatePairs.add(index1, new Point(x, y));
                }

        } catch (IOException e) {
            System.out.println("Could not open the file." + e);
            System.exit(0);
        }

        return coordinatePairs;
    }


}
