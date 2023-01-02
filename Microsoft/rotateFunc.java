package Microsoft;

public class rotateFunc {
    
    public int maxRotateFunction(int[] nums) {
        int maxVal = 0;
        int sum = 0, F0 = 0;
        int cur , prev;
        int n = nums.length;

        for(int i = 0; i < n; i++) {

            sum += nums[i];
            F0 += i * nums[i];
        }
        maxVal = F0;
        prev = F0;

        for(int i = 1; i < n; i++) {

            cur = prev + sum - n * nums[n-i];
            prev = cur;
            maxVal = Math.max(cur, maxVal);
        }
        return maxVal;
    }
}