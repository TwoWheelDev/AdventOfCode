package Yr2018.Day01;

public class Main {
    public static void main(String[] args) {
        FreqShift fs = new FreqShift("./Day01/input.txt");

        System.out.println("Part One: " + fs.runPart1());

        fs.setCurFreq(0);

        System.out.println("Part Two: " + fs.runPart2());

        fs.closeFile();
    }
}