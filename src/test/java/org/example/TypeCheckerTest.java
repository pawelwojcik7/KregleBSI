package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.example.models.Queue;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TypeCheckerTest {

  @Test
  @Parameters({
    "10, 0, FALSE, STRIKE",
    "0, 0, FALSE, MISS",
    "3, 4, FALSE, OPEN_FRAME",
    "0, 10, FALSE, SPARE",
    "8, 1, TRUE, SPLIT",
    "8, 1, FALSE, OPEN_FRAME"
  })
  public void checkQueueType(int points1, int points2, Boolean ifSplit, String expectedType) {

    Queue queue = new Queue(points1, points2, null, points1 + points2);
    TypeChecker instance = new TypeChecker();
    instance.checkAndSet(queue, ifSplit);
    assertEquals(queue.getType().toString(), expectedType);
  }
}
