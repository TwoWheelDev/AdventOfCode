package Yr2020.Day06;

import java.util.ArrayList;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir")+"/Yr2020/Day06/input.txt");
        ir.loadFile();
        ArrayList<String> input = ir.toArrayList();
        CustomsForm cf = new CustomsForm();
        System.out.println("Part 1: " + cf.runPart1(input));
        System.out.println("Part 2: " + cf.runPart2(input));
    }
}
