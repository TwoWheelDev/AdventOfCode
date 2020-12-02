package Yr2018.Day03;

import java.util.ArrayList;

public class Fabric {
    private ArrayList<ArrayList<String>> fabric;
    private ArrayList<Claim> claims;

    public Fabric(int size) {
        this.fabric = new ArrayList<>();
        this.claims = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            ArrayList<String> inner = new ArrayList<>();

            for (int j = 0; j<size; j++) {
                inner.add(".");
            }

            this.fabric.add(inner);
        }
    }

    public void addClaim(String claim) {
        Claim tmpClaim = new Claim(claim);
        this.claims.add(tmpClaim);

        // Plot on the fabric
        for (int y =  tmpClaim.getyPos(); y < tmpClaim.getyEnd(); y++) {
            for (int x = tmpClaim.getxPos(); x < tmpClaim.getxEnd(); x++) {
                String current = this.fabric.get(y).get(x);

                if (current.equals(".")) {
                    this.fabric.get(y).set(x, tmpClaim.getClaimId());
                } else {
                    this.fabric.get(y).set(x, "X");
                }
            }
        }
    }

    public void printFabric() {
        for (ArrayList<String> row : this.fabric) {
            System.out.println(String.join("", row));
        }
    }

    public int countOverlap() {
        int overlap = 0;
        for (int y = 0; y<this.fabric.size(); y++) {
            ArrayList<String> column = this.fabric.get(y);
            for(int x = 0; x<column.size(); x++) {
                if (column.get(x).equals("X")) overlap++;
            }
        }

        return overlap;
    }

    public String getGoodClaim() {
        ArrayList<Claim> validClaims = new ArrayList<>();
        for (Claim claim : this.claims) {
            boolean valid = true;
            for (int y = claim.getyPos(); y < claim.getyEnd(); y++) {
                for (int x = claim.getxPos(); x < claim.getxEnd(); x++) {
                    if (this.fabric.get(y).get(x).equals("X")) valid = false;
                }
            }

            if (valid) validClaims.add(claim);
        }
        if (validClaims.size() == 1) {
            return validClaims.get(0).getClaimId();
        } else {
            System.out.println("Error, multiple valid claims!");
            return "";
        }
        
    }
}

