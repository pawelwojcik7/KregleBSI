package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Queue {

    private int throw1;
    private int throw2;
    private QueueType type;
    private int sumOfPoints;

    public Queue(){

    }

}
