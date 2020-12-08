package Yr2020.Day07;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir")+"/Yr2020/Day07/input.txt");
        ir.loadFile();

        BagPacker bagPacker = new BagPacker(ir.toArrayList());
        System.out.println("Part 1: " + bagPacker.runPart1());
        System.out.println("Part 2: " + bagPacker.runPart2());
    }
}
