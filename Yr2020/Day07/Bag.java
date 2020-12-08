package Yr2020.Day07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class Bag {
    private String bagColor;
    private HashMap<String, Integer> contains = new HashMap<>();
    
    public Bag(String bag) {       

        Pattern p = Pattern.compile("^([\\w\\s]+) bags contain");
        Matcher m1 = p.matcher(bag);

        m1.find();
        this.bagColor = m1.group(1);

        p = Pattern.compile("(\\d) ([\\w\\s]+) bags?");
        m1 = p.matcher(bag);
        while(m1.find()) {
            this.contains.put(m1.group(2), Integer.valueOf(m1.group(1)));
        }
    }

    public String canContainThisBag(String bag) {
        if (this.contains.containsKey(bag)) {
            return this.bagColor;
        }

        return null;
    }

    public String getBagColour() {
        return this.bagColor;
    }

    public HashMap<String, Integer> getChildren() {
        return this.contains;
    }

    public int getNumChildren() {
        return this.contains.size();
    }
}
