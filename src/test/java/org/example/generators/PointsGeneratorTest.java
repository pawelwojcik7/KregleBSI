package org.example.generators;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(JUnitParamsRunner.class)
public class PointsGeneratorTest {

  @Test
  @Parameters({"0, 0, 0", "1, 1, 1", "1, 1, 1", "10, 10, 10"})
  public void generatePoints(int min, int max, int expected) {
    int points = PointsGenerator.generatePoints(min,max);
    assertEquals(expected, points);
  }

  @Test
  @Parameters({"0, 5", "1, 1", "0,10", "9,10"})
  public void generatePoints2(int min, int max) {
    int expectedPoints = PointsGenerator.generatePoints(min,max);
    assert(expectedPoints>=min&&expectedPoints<=max);
  }

}