package com.kovieraite.location.Input;

import com.kovieraite.location.Point;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class Decoder {

    private String fileName;

    public Decoder(String fileName){
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
            RandomAccessFile aFile = new RandomAccessFile(file, "r");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect( length * 2 );

            int bytesRead = inChannel.read(buf);
            int cnt=0;
            short[] result = new short[length];
            while (bytesRead != -1) {

                buf.flip();

                while(buf.hasRemaining() && cnt < length*2){
                    // probably slow here since called 500 000 times
                    short x=buf.getShort();
                    short y=buf.getShort();
                    coordinatePairs.add(cnt, new Point(x, y));
                    cnt++;
                }

                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }

        } catch (IOException e) {
            System.out.println("Could not open the file." + e);
            System.exit(0);
        }

        return coordinatePairs;
    }


}
