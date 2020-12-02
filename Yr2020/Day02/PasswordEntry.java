package Yr2020.Day02;

public class PasswordEntry {
    private int minChar;
    private int maxChar;
    private char testChar;
    private String password;

    public PasswordEntry(String entry) {
        if (!entry.isBlank()) {
            String[] eParts = entry.split("[ -]");
            this.minChar = Integer.valueOf(eParts[0]);
            this.maxChar = Integer.valueOf(eParts[1]);

            this.testChar = eParts[2].charAt(0);
            this.password = eParts[3];
        }
    }

    public String getPassword() {
        return this.password;
    }

    public int getMinChar() {
        return this.minChar;
    }

    public int getMaxChar() {
        return this.maxChar;
    }

    public char getTestChar() {
        return this.testChar;
    }

}
