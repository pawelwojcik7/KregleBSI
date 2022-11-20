package org.example.generators;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;


public class SplitGeneratorTest {

  @Test
  public void generateSplit() {

    assertThat(SplitGenerator.generateSplit(), instanceOf(Boolean.class));
  }
}
