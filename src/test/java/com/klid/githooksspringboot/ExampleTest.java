package com.klid.githooksspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** @author Ivan Kaptue */
public class ExampleTest {

  @Test
  public void test_addition() {
    var result = 6 + 7;

    assertEquals(13, result);
  }

  @Test
  public void test_helloWorld() {
    assertTrue(true);
  }
}
