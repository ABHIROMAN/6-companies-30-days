package Microsoft;

public class shortestUnsortedContSubarray {
    
    public int findUnsortedSubarray(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;

        while(start+1 < nums.length && nums[start] <= nums[start+1]) {
            start++;
        }

        if(start == nums.length-1) return 0;

        while(end-1 >= 0 && nums[end-1] <= nums[end]) {
            end--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while(start-1 >= 0 && nums[start-1] > min) {
            start--;
        }

        while(end+1 < nums.length && nums[end+1] < max) {
            end++;
        }
        
        return end-start+1;
    }
}
