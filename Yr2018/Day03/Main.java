package Yr2018.Day03;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        Fabric fab = new Fabric(1000);
        String filename = System.getProperty("user.dir")+"/Day03/input.txt";
        InputReader iReader = new InputReader(filename);
        String line;
        iReader.loadFile();
        while ((line = iReader.readLine()) != null) {
            fab.addClaim(line);
        }
        System.out.println(fab.countOverlap());
        System.out.println(fab.getGoodClaim());
    }
}
