package Yr2018.Day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Utils.InputReader;

public class BoxIdChecker {
    private InputReader iReader;

    public BoxIdChecker(String inputFile) {
        this.iReader = new InputReader(this.getClass().getResource(inputFile).getFile());
    }

    public int runPart1() {
        int contains2 = 0;
        int contains3 = 0; 
        this.iReader.loadFile();
        String line = this.iReader.readLine();

        while (line != null) {
            if (strContainsXChars(line, 2)) contains2++;
            if (strContainsXChars(line, 3)) contains3++;
            line = this.iReader.readLine();
        }

        return contains2 * contains3;
    }

    public String runPart2() {        
        this.iReader.loadFile();
        ArrayList<String> input = this.iReader.toArrayList();
        ArrayList<String> commonCharacters = new ArrayList<>();

        for (String line1 : input) {
            int diff = 0;
            for (String line2 : input) {
                if (!line1.equals(line2)) {
                    diff = 0;
                    commonCharacters.clear();
                    List<Character> s1List = line1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
                    List<Character> s2List = line2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

                    for (int i = 0; i < s1List.size(); i++) {
                        if (s1List.get(i) != s2List.get(i)) {
                            diff++;
                        } else {
                            commonCharacters.add(s1List.get(i).toString());
                        }
                    }

                    if (diff == 1) { 
                        String result = String.join("", commonCharacters);
                        return result;
                    }
                }
            }
        }

        return null;  
    }

    private boolean strContainsXChars(String x, int numToFind) {
        char[] chars = x.toCharArray();
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (char letter : chars) {
            charCounts.put(letter, charCounts.getOrDefault(letter, 0) + 1);
        }
        
        if (charCounts.containsValue(numToFind)) {
            return true;
        }

        return false;
    }
}
