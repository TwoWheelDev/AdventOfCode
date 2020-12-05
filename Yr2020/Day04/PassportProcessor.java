package Yr2020.Day04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PassportProcessor {
    List<String> passports = new ArrayList<>();
    List<String> validPassports = new ArrayList<>();
    
    public void loadPassports(ArrayList<String> input) {
        StringBuilder sb = new StringBuilder();

        for(String line:input) {
            if (line.isBlank()) {
                this.passports.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if(sb.length() > 0) sb.append(" ");
                sb.append(line);
            }
        }

        if(sb.length() > 0) this.passports.add(sb.toString());
    }

    private boolean checkPassport(String line) {
        String[] required = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        boolean valid = true;

        for(String element:required) {
            if(!line.contains(element)) valid = false;
        }

        if(valid) this.validPassports.add(line);

        return valid;
    }

    private boolean checkPassport2(String line) {
        boolean valid = checkPassport(line);
        String[] lineParts = line.split(" ");

        if(!valid) return valid;        

        for(String part:lineParts) {
            if(!valid) break;
            String[] kv = part.split(":");

            switch (kv[0]) {
                case "byr":
                    int byr = Integer.valueOf(kv[1]);
                    if (byr < 1920 || byr > 2002) valid = false;
                    break;
                case "iyr":
                    int iyr = Integer.valueOf(kv[1]);
                    if (iyr<  2010 || iyr > 2020) valid = false;
                    break;
                case "eyr":
                    int eyr = Integer.valueOf(kv[1]);
                    if (eyr < 2020 || eyr > 2030) valid = false;
                    break;
                case "hgt":
                    if (kv[1].contains("in")) {
                        int hgt = Integer.valueOf(kv[1].substring(0, kv[1].length()-2));
                        if (hgt < 59 || hgt > 76) valid = false; 
                    } else if (kv[1].contains("cm")) {
                        int hgt = Integer.valueOf(kv[1].substring(0, kv[1].length()-2));
                        if (hgt < 150 || hgt > 193) valid = false; 
                    } else {
                        valid = false;
                    }
                    break;
                case "hcl":
                    Pattern pattern = Pattern.compile("#[\\da-f]{6}");
                    Matcher matcher = pattern.matcher(kv[1]);

                    if(!matcher.find()) valid = false;
                    break;
                case "ecl":
                    valid = false;
                    String[] eyeColours = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                    for (String colour:eyeColours) {
                        if(kv[1].equals(colour)) valid = true;
                    }                    
                    break;
                case "pid":
                    if(kv[1].length() != 9) valid = false;
                    break;           
            }
        }

        return valid;
    }

    public int runPart1() {
        int counter = 0;
        for(String line:passports) {
            if(checkPassport(line)) counter++;
        }

        return counter;
    }

    public int runPart2() {
        Iterator<String> iter = this.passports.iterator();
        int counter = 0;
        while(iter.hasNext()) {
            if(checkPassport2(iter.next())) counter++;
        }

        return counter;
    }
}
