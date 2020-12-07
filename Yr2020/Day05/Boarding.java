package Yr2020.Day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boarding {
    List<String> boadingPasses = new ArrayList<>();
    List<Integer> seatIds = new ArrayList<>();

    public Boarding(List<String> passes) {
        this.boadingPasses = passes;
    }

    public int runPart1() {
        for(String pass:this.boadingPasses) {
            char[] seatChars = pass.toCharArray();

            int rowLower = 0;
            int rowUpper = 127;

            int columnLower = 0;
            int columnUpper = 7;

            for (int i=0; i<7; i++) {
                int rowsRange = rowUpper - rowLower;
                int midPoint = Math.floorDiv(rowsRange, 2) + 1;
                if(seatChars[i] == 'F') {
                    rowUpper -= midPoint;
                } else {
                    rowLower += midPoint;
                }
            }

            for (int i=7; i<pass.length(); i++) {
                int columnRange = columnUpper - columnLower;
                int midPoint = Math.floorDiv(columnRange, 2) + 1;

                if(seatChars[i] == 'L') {
                    columnUpper -= midPoint;
                } else {
                    columnLower += midPoint;
                }
            }

            int seatId = rowUpper * 8 + columnUpper;
            this.seatIds.add(seatId);
        }

        return Collections.max(seatIds);
    }

    public int runPart2() {
        int mySeat = 0;
        Collections.sort(this.seatIds);
        
        for (int i=0; i<this.seatIds.size()-1; i++) {
            if(this.seatIds.get(i+1) - this.seatIds.get(i) > 1) {
                mySeat = this.seatIds.get(i)+1;
            }
        }

        return mySeat;
    }
}
