package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Queue {

    private Throw throw1;
    private Throw throw2;
    private QueueType type;
    private int sumOfPoints;

}
