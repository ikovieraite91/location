package com.kovieraite.location;

import com.kovieraite.location.Input.Decoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class PointsLocationCalculatorTest {

    private PointsLocationCalculator pointsLocationCalculator;
    private Decoder decoder;

    @Before
    public void setUp(){
        decoder=new Decoder("points");
        pointsLocationCalculator=new PointsLocationCalculator();
    }

    @Test
    public void testIfDistanceIsCalculatedCorrectly(){

        Point point1=new Point( -2,  1);
        Point point2=new Point( 1,  5);

        double expectedDistance=5.0;
        double actualDistance = pointsLocationCalculator.calculateDistanceBetweenPoints(point1, point2);

        Assert.assertEquals(expectedDistance, actualDistance, 0.1);

    }

    @Test
    public void testIfFindsTheClosestPoint(){
        int numberOfClosestPoints=1;
        Point centralPoint=  new Point( 0,  0);
        List<Point> points=new ArrayList<>();

        points.add(0, new Point(-4,-5));
        points.add(1, new Point(1,1));
        points.add(2, new Point(7,8));
        points.add(3, new Point(3,5));

        Point expectedClosestPoints=points.get(1);
        List<Point> actualClosestPoint=pointsLocationCalculator.getNumberOfClosestPoints(numberOfClosestPoints, centralPoint, points);

        Assert.assertEquals(expectedClosestPoints.getxCoord(), actualClosestPoint.get(0).getxCoord());
        Assert.assertEquals(expectedClosestPoints.getyCoord(), actualClosestPoint.get(0).getyCoord());
        Assert.assertEquals(1, actualClosestPoint.size());

    }

    @Test
    public void testIfFindsTheFurthestPoints(){
        int numberOfFurthestPoints=1;
        Point centralPoint=  new Point( 0,  0);
        List<Point> points=new ArrayList<>();

        points.add(0, new Point(3,-5));
        points.add(1, new Point(140,1999));
        points.add(2, new Point(100,100));
        points.add(3, new Point(-4,-5));

        Point expectedFurthestPoint=points.get(1);

        List<Point> actualFurthestPoints=pointsLocationCalculator.getNumberOfFurthestPoints(numberOfFurthestPoints, centralPoint, points);

        Assert.assertEquals(expectedFurthestPoint.getxCoord(), actualFurthestPoints.get(0).getxCoord());
        Assert.assertEquals(expectedFurthestPoint.getyCoord(), actualFurthestPoints.get(0).getyCoord());
        Assert.assertEquals(1, actualFurthestPoints.size());

    }

    @Test
    public void testHowMuchTimeItTakesToGetFurthestPoints() {
        Point centralPoint=  new Point( 0,  0);
        List<Point> points= decoder.getArrayOfIntegerValuePairsFromBinaryFile(10000000);

        long startTime=System.currentTimeMillis();
        pointsLocationCalculator.getNumberOfFurthestPoints(20, centralPoint, points);
        System.out.println("Time taken to get the furthest points once the binary file is read: "+(System.currentTimeMillis()-startTime)/1000);
    }

    @Test
    public void testHowMuchTimeItTakesToGetClosestPoints() {
        Point centralPoint=  new Point( 0,  0);
        List<Point> points= decoder.getArrayOfIntegerValuePairsFromBinaryFile(10000000);

        long startTime=System.currentTimeMillis();
        pointsLocationCalculator.getNumberOfClosestPoints(10, centralPoint, points);
        System.out.println("Time taken to get the closest points once the binary file is read: "+(System.currentTimeMillis()-startTime)/1000);
    }

}