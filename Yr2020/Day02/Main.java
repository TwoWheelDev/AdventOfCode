package Yr2020.Day02;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir")+"/Yr2020/Day02/input.txt");
        ir.loadFile();
        PasswordChecker pc = new PasswordChecker();
        pc.loadEntries(ir.toArrayList());
        System.out.println("Part 1:" + pc.runPart1());
        System.out.println("Part 2:" + pc.runPart2());
    }
}