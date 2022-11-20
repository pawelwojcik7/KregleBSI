package org.example.generators;

// 10% for faul
public class FaulGenerator {

    public static Boolean generateIfFaul(){

        int randomNumber = (int) (Math.random()*(10));
        return randomNumber == 4;

    }
}
