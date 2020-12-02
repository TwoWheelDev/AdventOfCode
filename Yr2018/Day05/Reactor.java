package Yr2018.Day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reactor {
    private List<Character> polymerString;

    public void setPolymerString(String s) {
        this.polymerString = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public String getPolymerString() {
        return this.polymerString.stream()
            .map(c -> String.valueOf(c))
            .collect(Collectors.joining(""));
    }

    public int getPolymerLength() {
        return this.polymerString.size();
    }

    public void react() {
        boolean run = true;
        while (run) {
            run = false;
            for (int i = 0; i<this.polymerString.size()-1; i++) {
                Character workingChar = this.polymerString.get(i);
                Character nextChar = this.polymerString.get(i + 1);
                if ((Character.isUpperCase(workingChar) && Character.isLowerCase(nextChar)) || 
                    (Character.isLowerCase(workingChar) && Character.isUpperCase(nextChar))) {
                        if (Character.toUpperCase(workingChar) == nextChar || 
                                workingChar == Character.toUpperCase(nextChar)) {
                            this.polymerString.remove(i);
                            this.polymerString.remove(i);
                            run = true;
                        }
                    }
                
            }
        }
    }

    public int react2(char x) {
        List<Character> toRemove = new ArrayList<>();
        toRemove.add(x);
        toRemove.add(Character.toUpperCase(x));
        this.polymerString.removeAll(toRemove);
        this.react();
        return this.getPolymerLength();
    }
}
