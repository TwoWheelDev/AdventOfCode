package Yr2018.Day02;

public class Main {
    public static void main(String[] args) {
        BoxIdChecker bic = new BoxIdChecker("input.txt");
        System.out.println(bic.runPart1());
        System.out.println(bic.runPart2());
    }
}
