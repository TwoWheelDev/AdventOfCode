package Yr2020.Day06;

import java.util.ArrayList;
import java.util.List;

public class CustomsForm {
    public long runPart1(List<String> input) {
        List<String> entries = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String line: input) {
            if(line.isBlank()) {
                entries.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(line);
            }
        } 

        entries.add(sb.toString());

        long sum = 0;
        for(String entry:entries) {
            sum += entry.chars().distinct().count();
        }

        return sum;
    }

    public int runPart2(List<String> input) {
        List<List<String>> groups = new ArrayList<>();

        ArrayList<String> tmpList = new ArrayList<>();
        for (String line: input) {
            if(line.isBlank()) {
                groups.add((List<String>)tmpList.clone());
                tmpList.clear();
            } else {
                tmpList.add(line);
            }
        }
        groups.add((List<String>)tmpList.clone());

        char[] questions = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int total = 0;
        for(List<String> group:groups) {
            List<Character> allCorrect = new ArrayList<>();
            for(char q:questions) {
                boolean allYes = true;
                for(String person:group) {
                    if (!person.contains(String.valueOf(q))) {
                        allYes = false;
                    }
                }

                if (allYes) allCorrect.add(q);
            }

            total += allCorrect.size();
        }

        return total;
    }
}
