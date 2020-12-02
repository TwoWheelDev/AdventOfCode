package Yr2018.Day05;

import java.util.ArrayList;
import java.util.Collections;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader iReader = new InputReader(System.getProperty("user.dir") + "/Day05/input.txt");
        Reactor r = new Reactor();

        // Part 1
        iReader.loadFile();
        r.setPolymerString(iReader.readLine());
        r.react();
        System.out.println(r.getPolymerLength());
        
        // Part 2
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<Integer> polymerLength = new ArrayList<>();

        for (char c : letters) {
            iReader.loadFile();
            r.setPolymerString(iReader.readLine());
            polymerLength.add(r.react2(c));
        }

        System.out.println("Part 2: " + Collections.min(polymerLength));
    }
}
