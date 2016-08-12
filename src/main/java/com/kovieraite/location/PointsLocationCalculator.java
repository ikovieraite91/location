package com.kovieraite.location;

import java.util.Collections;
import java.util.List;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class PointsLocationCalculator {

    public double calculateDistanceBetweenPoints(Point point1, Point point2){

        double xDiff= point2.getxCoord()-point1.getxCoord();
        double yDiff=point2.getyCoord()-point1.getyCoord();

        double distance=Math.sqrt(xDiff*xDiff+yDiff*yDiff);

        return distance;
    }

    public List<Point> getNumberOfClosestPoints(int numberOfClosestPoints, Point centre, List<Point> points){
        List<Point> closestPoints;

        for(int index=0; index<points.size(); index++){
            points.get(index).setDistanceFromCentre(calculateDistanceBetweenPoints(points.get(index), centre));
        }

        Collections.sort(points);
        closestPoints = points.subList(points.size()-numberOfClosestPoints, points.size());

        return closestPoints;
    }

    public List<Point> getNumberOfFurthestPoints(int numberOfFurthestPoints, Point centre, List<Point> points){
        List<Point> furthestPoints;

        for(int index=0; index<points.size(); index++){
            points.get(index).setDistanceFromCentre(calculateDistanceBetweenPoints(points.get(index), centre));
        }

        Collections.sort(points);
        furthestPoints=points.subList(0, numberOfFurthestPoints);


        return furthestPoints;
    }




}
