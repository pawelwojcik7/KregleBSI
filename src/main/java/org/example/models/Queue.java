package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Queue {

    private Throw throw1;
    private Throw throw2;
    private QueueType type;
    private int sumOfPoints;

    public Queue(){
        this.throw1= new Throw();
        this.throw2 = new Throw();
    }

}
