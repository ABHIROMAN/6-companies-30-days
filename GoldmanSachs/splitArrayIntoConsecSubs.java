package GoldmanSachs;

import java.util.*;

public class splitArrayIntoConsecSubs {
    
    public boolean isPossible(int[] nums) {
        
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {

            if(!countMap.containsKey(num) || countMap.get(num) == 0) {
                continue;
            }

            int currNum = num;
            int sequenceFreq = countMap.get(num);
            int sequenceCount = 0;

            while(countMap.containsKey(currNum) && countMap.get(currNum) >= sequenceFreq) {

                sequenceFreq = Math.max(sequenceFreq, countMap.get(currNum));
                countMap.put(currNum, countMap.get(currNum) - 1);
                sequenceCount++;
                currNum++;
            }

            if(sequenceCount < 3) {
                return false;
            }
        }
        return true;
    }
}
