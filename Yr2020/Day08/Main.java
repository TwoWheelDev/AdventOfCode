package Yr2020.Day08;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Utils.InputReader;

public class Main {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.getProperty("user.dir") + "/Yr2020/Day08/input.txt");
        ir.loadFile();
        ArrayList<String> program = ir.toArrayList();
        Console console = new Console(program);
        long start  = System.nanoTime();
        console.runProgram();
        long end = System.nanoTime();
        double duration = (end-start)/1000000.0;

        System.out.println("Part 1: " + console.getAcc() + " (Time taken : " + df.format(duration) + "ms)");

        start  = System.nanoTime();
        boolean keepTrying = true;
        while(keepTrying) {
            for (int i=0; i<program.size(); i++) {
                if(program.get(i).startsWith("nop")) {
                    String oldInstruction = program.get(i);
                    String newInstruction = program.get(i).replaceAll("nop", "jmp");
                    console.updateProgramLine(i, newInstruction);
                    console.runProgram();
                    if(console.isInfiniteLoop()) {
                        console.updateProgramLine(i, oldInstruction);
                    } else {
                        keepTrying = false;
                        break;
                    }
                } else if(program.get(i).startsWith("jmp")) {
                    String oldInstruction = program.get(i);
                    String newInstruction = program.get(i).replaceAll("jmp", "nop");
                    console.updateProgramLine(i, newInstruction);
                    console.runProgram();
                    if(console.isInfiniteLoop()) {
                        console.updateProgramLine(i, oldInstruction);
                    } else {
                        keepTrying = false;
                        break;
                    }
                }
                console.reset();
            }
        }
        end = System.nanoTime();
        duration = (end-start)/1000000.0;
        System.out.println("Part 2: " + console.getAcc() + " (Time taken : " + df.format(duration) + "ms)");
    }
}
