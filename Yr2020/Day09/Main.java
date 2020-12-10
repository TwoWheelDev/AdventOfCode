package Yr2020.Day09;

import java.text.DecimalFormat;
import Utils.InputReader;

public class Main {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir")+"/Yr2020/Day09/input.txt");
        ir.loadFile();

        XmasDecoder xd = new XmasDecoder(ir.toArrayList());
        long start  = System.nanoTime();
        long result = xd.runPart1();
        long end = System.nanoTime();
        double duration = (end-start)/1000000.0;
        System.out.println("Part1: " + result + " (Time taken : " + df.format(duration) + "ms)");

        start  = System.nanoTime();
        result = xd.runPart2(result);
        end = System.nanoTime();
        duration = (end-start)/1000000.0;
        System.out.println("Part2: " + result + " (Time taken : " + df.format(duration) + "ms)");
    }
}