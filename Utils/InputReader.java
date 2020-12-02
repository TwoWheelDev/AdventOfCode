package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {
    private FileReader fr;
    private BufferedReader input;
    private String fileName;

    public InputReader(String filename) {;
        this.fileName = filename;
    }

    public void loadFile() {
        try {
            this.fr = new FileReader(fileName);
            this.input = new BufferedReader(this.fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  
    }

    public String readLine() {
        String line = null;
        try {
            line = this.input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public ArrayList<String> toArrayList() {
        ArrayList<String> lines = new ArrayList<>();

        String line = this.readLine();
        while (line != null) {
            lines.add(line);
            line = this.readLine();
        }

        return lines;
    }

    public void closeFile() {
        try {
            this.fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
