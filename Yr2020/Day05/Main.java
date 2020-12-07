package Yr2020.Day05;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir") + "/Yr2020/Day05/input.txt");
        ir.loadFile();

        Boarding boarding = new Boarding(ir.toArrayList());
        System.out.println("Part 1: " + boarding.runPart1());
        System.out.println("Part 2: " + boarding.runPart2());
    } 
}
