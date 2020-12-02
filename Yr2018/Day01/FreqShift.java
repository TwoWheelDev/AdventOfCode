package Yr2018.Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.io.FileNotFoundException;

public class FreqShift {
    private int curFreq = 0;
    private FileReader fr;
    private BufferedReader input;
    private String fileName;

    public FreqShift(String fileName) {
        this.fileName = fileName;
    }

    public void loadFile() {
        try {
            this.fr = new FileReader(fileName);
            this.input = new BufferedReader(this.fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
    }

    public int runPart1() {
        this.loadFile();
        String line = this.readLine();
        while (line != null) {
            this.curFreq += Integer.parseInt(line.strip());
            line = this.readLine();
        }

        return this.curFreq;
    }

    public int runPart2() {
        HashSet<Integer> seenFreqs = new HashSet<Integer>();
        boolean resultFound = false;

        do {
            this.loadFile();
            String line = this.readLine();
            while (line != null) {
                this.curFreq += Integer.parseInt(line.strip());
                if(!seenFreqs.contains(this.curFreq)) {
                    seenFreqs.add(this.curFreq);
                    line = this.readLine();
                } else {
                    resultFound = true;
                    break;
                }
            }
        } while (!resultFound);

        return this.curFreq;
    }

    public void setCurFreq(int i) {
        this.curFreq = i;
    }
    
    public void closeFile() {
        try {
            this.fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLine() {
        String line = null;
        try {
            line = this.input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
