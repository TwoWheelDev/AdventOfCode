package Yr2020.Day04;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir") + "/Yr2020/Day04/input.txt");
        ir.loadFile();

        PassportProcessor pp = new PassportProcessor();
        pp.loadPassports(ir.toArrayList());
        System.out.println("Part 1: " + pp.runPart1());
        System.out.println("Part 2: " + pp.runPart2());
    }
}
