package Yr2020.Day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BagPacker {
    private List<Bag> bags = new ArrayList<>();
    private HashMap<String, Bag> bagMap = new HashMap<>();

    public BagPacker(ArrayList<String> input) {
        for (String line:input) {
            Bag tmpBag = new Bag(line);
            this.bags.add(tmpBag);
            this.bagMap.put(tmpBag.getBagColour(), tmpBag);
        }
    }

    private int getBags(Bag parent) {
        int numBags = 1;

        for (Map.Entry<String, Integer> entry : parent.getChildren().entrySet()) {
            int someNum = getBags(this.bagMap.get(entry.getKey()));
            numBags += someNum * entry.getValue();
        }

        return numBags;
    }

    public int runPart1() {
        ArrayList<String> validBags = new ArrayList<>();
        boolean bagFound = false;

        for(Bag tryBag: this.bags) {
            String vBag = tryBag.canContainThisBag("shiny gold");
            if(vBag != null && !validBags.contains(vBag)) {
                validBags.add(vBag);
            }
        }

        do {
            ArrayList<String> tmpValid = new ArrayList<>();
            for(String bag: validBags) {
                for(Bag tryBag: this.bags) {
                    String vBag = tryBag.canContainThisBag(bag);
                    if(vBag != null && !tmpValid.contains(vBag) && !validBags.contains(vBag)) {
                        tmpValid.add(vBag);
                    }
                }
            }
            if (tmpValid.size() > 0) {
                bagFound = true;
                validBags.addAll(tmpValid);
            } else {
                bagFound = false;
            }
            
        } while(bagFound);

        return validBags.size();
    }
    
    public int runPart2() {
        return getBags(this.bagMap.get("shiny gold")) -1;
    }
}
