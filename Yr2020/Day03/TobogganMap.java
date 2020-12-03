package Yr2020.Day03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TobogganMap {
    private ArrayList<ArrayList<Character>> map = new ArrayList<>();

    public TobogganMap(ArrayList<String> input) {
        for (String s:input) {
            ArrayList<Character> row = new ArrayList<>();
            List<Character> charList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            for (int i=0; i<input.size()*7; i++) {
                row.addAll(charList);
            }

            this.map.add(row);
        }
    }

    private int traverseMap(int right, int down) {
        int counter = 0;
        int xPos = 0;

        for (int y=down; y<this.map.size(); y+=down) {
            xPos += right;

            if(this.map.get(y).get(xPos) == '#') counter++;
        }

        return counter;
    }

    public int runPart1() {
        return traverseMap(3, 1);
    }

    public long runPart2() {
        
        List<Integer> results = new ArrayList<>();
        results.add(traverseMap(1, 1));
        results.add(traverseMap(3, 1));
        results.add(traverseMap(5, 1));
        results.add(traverseMap(7, 1));
        results.add(traverseMap(1, 2));

        long result = 1;
        for (int i:results) {
            result *= i;
        }

        return result;
    }
}