package GoldmanSachs;

import java.util.*;

public class maxPointsLine {
    
    public int maxPoints(int[][] points) {
        
        if(points.length < 3) return points.length;
        int maxPoints = 0;

        for(int [] check1 : points) {

            Map<Double, Integer> hm = new HashMap<>();
            for(int[] check2 : points) {
                if(check1 == check2) continue;
                    double slope = 0;
                    if(check1[0] == check2[0]) 
                        slope = Double.POSITIVE_INFINITY;
                    else {
                    slope = (check2[1] - check1[1])/(double)(check2[0] - check1[0]);
                    }
                    hm.put(slope, hm.getOrDefault(slope, 0)+1);
                    if(hm.get(slope)>maxPoints)
                        maxPoints = hm.get(slope);
            }
        }
        return maxPoints + 1;
    }
}
