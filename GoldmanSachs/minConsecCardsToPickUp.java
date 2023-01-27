package GoldmanSachs;

import java.util.*;

public class minConsecCardsToPickUp {
    
    public int minimumCardPickup(int[] cards) {
        
        int ans = Integer.MAX_VALUE;
        int n = cards.length;

        HashMap<Integer, Pair<Integer, Integer>> cardCount = new HashMap<>();

        for(int i = 0; i < n; i++) {

            int lastCount = cardCount.getOrDefault(cards[i], new Pair<>(0, 0)).getKey();
            int lastIndex = cardCount.getOrDefault(cards[i], new Pair<>(0, 0)).getValue();

            cardCount.put(cards[i], new Pair<>(lastCount + 1, i));

            if (lastCount + 1 > lastCount && lastCount != 0) {
                int current = i - lastIndex - 1;
                ans = Math.min(current, ans);
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
