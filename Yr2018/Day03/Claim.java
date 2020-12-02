package Yr2018.Day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    private String claimId;
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public Claim(String claim) {
        // Group 1 - Claim ID
        // Group 2,3 - X,Y Position
        // Group 4,5 - Width, Height
        //Pattern rx = Pattern.compile("#(\\d+) @ (\\d+),([\\d+): (\\d+)x(\\d+)");
        Pattern rx = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
        Matcher mc = rx.matcher(claim);
        // Store the claim elements
        if (mc.matches()) {
            this.setClaimId(mc.group(1));
            this.setxPos(Integer.valueOf(mc.group(2)));
            this.setyPos(Integer.valueOf(mc.group(3)));
            this.setWidth(Integer.valueOf(mc.group(4)));
            this.setHeight(Integer.valueOf(mc.group(5)));
        }
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getxEnd() {
        return xPos + width;
    }

    public int getyEnd() {
        return yPos + height;
    }
}
