package com.sparta.duplicates;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateCounter {
    public char[] findDuplicates(String theSampleString) {
        List<Character> charList = theSampleString
                // make lowercase, remove whitespace (\s = all whitespace chars)
                .toLowerCase()
                .replaceAll("\\s","")
                // turns string into IntStream of character ascii codes
                .chars()
                // turns each Integer into a character
                .mapToObj(e -> (char)e)
                // turn stream into list
                .collect(Collectors.toList());

        Set<Character> uniqueSet = new HashSet<>();
        Set<Character> dupeSet = new HashSet<>();

        // go through each character, add to uniqueSet if it doesn't already contain it, add to dupeSet if it does
        // .add() returns false boolean if it contains the item
        for (char c: charList) if (!uniqueSet.add(c)) dupeSet.add(c);

        return dupeSet
                .stream()
                // maps each character to a string
                .map(Object::toString)
                // collects into a single string
                .collect(Collectors.joining())
                // converts to a char array
                .toCharArray();
    }
}
