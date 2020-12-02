package Yr2020.Day01;
import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir")+"/Yr2020/Day01/input.txt");
        ir.loadFile();
        Day01 d1 = new Day01();
        d1.loadExpenses(ir.toArrayList());
        System.out.println(d1.runPart1());
        System.out.println(d1.runPart2());
    }
}