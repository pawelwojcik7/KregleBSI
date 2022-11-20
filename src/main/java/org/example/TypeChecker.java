package org.example;

import org.example.models.Queue;
import org.example.models.QueueType;

public class TypeChecker {

    public void checkAndSet(Queue queue) {
        if (!(queue.getThrow1().getIfFoul() && queue.getThrow2().getIfFoul())) {
            if (queue.getThrow1().getPoints() == 10) queue.setType(QueueType.STRIKE);
            if (queue.getThrow1().getPoints()==0 && queue.getThrow2().getPoints() == 0) queue.setType(QueueType.MISS);
            if (queue.getThrow1().getPoints() == 10) queue.setType(QueueType.STRIKE);
            if (queue.getThrow1().getPoints() == 10) queue.setType(QueueType.STRIKE);
            if (queue.getThrow1().getPoints() == 10) queue.setType(QueueType.STRIKE);
        }

    }

}
