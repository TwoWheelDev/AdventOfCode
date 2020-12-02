package Yr2020.Day02;
import java.util.ArrayList;

public class PasswordChecker {
    private ArrayList<PasswordEntry> entries = new ArrayList<>();

    public void loadEntries(ArrayList<String> entries) {
        for (String s: entries) {
            this.entries.add(new PasswordEntry(s));
        }
    }

    public boolean checkPassword(PasswordEntry entry) {
        long count = entry.getPassword().chars().filter(ch -> ch == entry.getTestChar()).count();

        if(count >= entry.getMinChar() && count <= entry.getMaxChar()) return true;
        return false;
    }

    public boolean checkPassword2(PasswordEntry entry) {
        char firstChar = entry.getPassword().charAt(entry.getMinChar()-1);
        char secondChar = entry.getPassword().charAt(entry.getMaxChar()-1);

        if (firstChar == secondChar) {
            return false;
        } else if(firstChar != entry.getTestChar() && secondChar != entry.getTestChar()) {
            return false;
        } else {
            return true;
        }
    }

    public int runPart1() {
        int counter = 0;
        for (PasswordEntry e: this.entries) {
            if(this.checkPassword(e)) counter += 1;
        }

        return counter;
    }

    public int runPart2() {
        int counter = 0;
        for (PasswordEntry e: this.entries) {
            if(this.checkPassword2(e)) counter += 1;
        }

        return counter;
    }
}