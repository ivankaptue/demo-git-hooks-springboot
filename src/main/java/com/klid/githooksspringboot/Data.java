package com.klid.githooksspringboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** @author Ivan Kaptue */
public interface Data {
  List<Person> PERSONS = new ArrayList<>();

  static long generateId() {
    Random random = new Random();
    return random.nextLong();
  }

  static int indexOf(long personId) {
    for (var i = 0; i < PERSONS.size(); i++) {
      var p = PERSONS.get(i);
      if (p.getId() == personId) return i;
    }
    return -1;
  }
}
