package Yr2020.Day03;
import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir") + "/Yr2020/Day03/input.txt");
        ir.loadFile();

        TobogganMap tm = new TobogganMap(ir.toArrayList());
        System.out.println("Part 1: " + tm.runPart1());
        System.out.println("Part 2: " + tm.runPart2());
        
    }
}
