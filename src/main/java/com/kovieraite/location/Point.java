package com.kovieraite.location;

import static java.lang.Double.compare;

/**
 * Created by ilonaK on 11/08/2016.
 */
public class Point implements Comparable<Point> {

    private int xCoord;
    private int yCoord;
    private double distanceFromCentre;

    public Point(int xCoord, int yCoord){
        this.xCoord=xCoord;
        this.yCoord=yCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public double getDistanceFromCentre() {
        return distanceFromCentre;
    }

    public void setDistanceFromCentre(double distanceFromCentre) {
        this.distanceFromCentre = distanceFromCentre;
    }

    @Override
    public int compareTo(Point point) {
        return compare(point.getDistanceFromCentre(), getDistanceFromCentre());
    }

}
