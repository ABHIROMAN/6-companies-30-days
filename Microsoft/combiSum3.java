package Microsoft;

import java.util.*;

public class combiSum3 {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        int arr[] = {1,2,3,4,5,6,7,8,9};

        helper(arr, n, 0, new ArrayList<Integer>(), k);
        return ans;
    }

    public void helper(int candidates[], int target, int rejected, ArrayList<Integer> list, int k) {

        if(target < 0) return;

        if(target == 0) {
            if(list.size() == k)
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i = rejected; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1, list, k);
            list.remove(list.size()-1);
        }
    }
}
