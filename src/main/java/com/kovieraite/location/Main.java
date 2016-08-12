package com.kovieraite.location;

import com.kovieraite.location.Input.Decoder;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        Decoder decoder=new Decoder("points");
        PointsLocationCalculator calculator=new PointsLocationCalculator();

        Point centralPointForClosest = new Point(-200, 300);
        Point centralPointForFurthest = new Point(1000, 25);
        DecimalFormat df2 = new DecimalFormat(".##");

        List<Point> points=decoder.getArrayOfIntegerValuePairsFromBinaryFile(10000000);


        List<Point> furthestPoints=calculator.getNumberOfFurthestPoints(20, centralPointForFurthest, points);
        System.out.println("Furthest Points: ");
        for(Point furthestPoint :  furthestPoints){
            System.out.println("X: "+ furthestPoint.getxCoord()+" Y: "+furthestPoint.getyCoord()+ " distance "+ df2.format(furthestPoint.getDistanceFromCentre()));
        }

        List<Point> closestPoints = calculator.getNumberOfClosestPoints(10, centralPointForClosest, points);
        System.out.println("Closest Points: ");
        for(Point closestPoint :  closestPoints){
            System.out.println("X: "+ closestPoint.getxCoord()+" Y: "+closestPoint.getyCoord()+ " distance "+ df2.format(closestPoint.getDistanceFromCentre()));
        }


    }

}
