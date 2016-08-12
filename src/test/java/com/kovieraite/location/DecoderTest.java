package com.kovieraite.location;

import com.kovieraite.location.Input.Decoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class DecoderTest {

    private Decoder decoder;
    private String fileName;

    @Before
    public void setUp(){
        fileName="points";
        decoder=new Decoder(fileName);
    }

    @Test
    public void testIfFileExists(){
        Assert.assertNotNull(decoder.getFileFromResources(fileName));
    }

    @Test
    public void testIfSizeOfFileIsAsExpected(){
        Assert.assertEquals(40000000, decoder.getFileFromResources(fileName).length());
    }

    @Test (expected = NullPointerException.class)
    public void testIfThrowsExceptionForNonExistantFile(){
        decoder.getFileFromResources("somethingRandom");
    }

    @Test
    public void testIfFirstThreePointsAreAsExpected(){
        Point expectedPoint1=new Point( -715,  22165);
        Point expectedPoint2=new Point( 761,  -23591);
        Point expectedPoint3=new Point( -194,  6014);

        List<Point> actualValues=decoder.getArrayOfIntegerValuePairsFromBinaryFile(4);
        Assert.assertEquals(expectedPoint1.getxCoord(), actualValues.get(0).getxCoord());
        Assert.assertEquals(expectedPoint1.getyCoord(), actualValues.get(0).getyCoord());
        Assert.assertEquals(expectedPoint2.getxCoord(), actualValues.get(1).getxCoord());
        Assert.assertEquals(expectedPoint2.getyCoord(), actualValues.get(1).getyCoord());
        Assert.assertEquals(expectedPoint3.getxCoord(), actualValues.get(2).getxCoord());
        Assert.assertEquals(expectedPoint3.getyCoord(), actualValues.get(2).getyCoord());
    }

    @Test
    public void howMuchTimeToReadWholeFile(){
        long startTime=System.currentTimeMillis();
        decoder.getArrayOfIntegerValuePairsFromBinaryFile(10000000);
        System.out.println("Time taken to read the whole binary file in seconds: "+(System.currentTimeMillis()-startTime)/1000);
    }

}
