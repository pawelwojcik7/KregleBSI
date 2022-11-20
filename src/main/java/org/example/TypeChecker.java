package org.example;

import org.example.models.Queue;
import org.example.models.QueueType;

public class TypeChecker {

    public void checkAndSet(Queue queue, Boolean ifSplit) {

            if (queue.getThrow1() == 10) queue.setType(QueueType.STRIKE);
            if(queue.getThrow1()+queue.getThrow2()==10&&queue.getThrow1()!=10) queue.setType(QueueType.SPARE);
            if (queue.getThrow1()==0 && queue.getThrow2() == 0) queue.setType(QueueType.MISS);
            if (queue.getThrow1() == 8 && queue.getThrow2()==1 && ifSplit) queue.setType(QueueType.SPLIT);
            if (queue.getType()==null) queue.setType(QueueType.OPEN_FRAME);

    }

}
