package org.example.generators;

public class PointsGenerator {


    public static int generatePoints(int min, int max){
        return (int) (Math.random()*(max-min+1)+(min));
    }

}
