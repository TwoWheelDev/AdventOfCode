package Yr2020.Day09;

import java.util.List;
import java.util.stream.Collectors;

public class XmasDecoder {
    private List<Long> dataStream;;
    
    public XmasDecoder(List<String> input) {
        this.dataStream = input.stream().map(num -> Long.parseLong(num)).collect(Collectors.toList());
        System.out.println();
    }

    private boolean checkForNumSum(int currentIdx) {
        int startPoint = currentIdx - 25;
        long targetVal = this.dataStream.get(currentIdx);

        for(int i=startPoint; i<currentIdx; i++) {
            long firstVal = this.dataStream.get(i);
            for (int j=startPoint; j<currentIdx; j++) {
                long secondVal = this.dataStream.get(j);
                if(firstVal == secondVal) {
                    break;
                } else if (firstVal+secondVal == targetVal) {
                    return true;
                }
            }
        }

        return false;
    }

    public long runPart1() {
        for(int i=26; i<this.dataStream.size(); i++) {
            if(!this.checkForNumSum(i)) return this.dataStream.get(i);
        }
        return -1;
    }

    public long runPart2(long value) {

        boolean foundSet = false;
        long min = 0;
        long max = 0;

        for (int setSize=2; setSize<this.dataStream.size(); setSize++) {
            for (int idx=0; idx<this.dataStream.size(); idx++) {
                if(idx+setSize > this.dataStream.size()) break;
                List<Long> tmpList = this.dataStream.subList(idx, idx+setSize);
                if(tmpList.stream().mapToLong(Long::longValue).sum() == value) {
                    min = tmpList.stream().min(Long::compare).get();
                    max = tmpList.stream().max(Long::compare).get();
                    foundSet = true;
                    break;
                }
            }
            if(foundSet) break;
        }

        return min + max;
    }
}
