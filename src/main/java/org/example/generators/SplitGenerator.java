package org.example.generators;

import java.util.Random;

public class SplitGenerator {

    public static Boolean generateSplit(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
