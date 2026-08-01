class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int minlen = Integer.MAX_VALUE;

        for(int high=0; high < nums.length; high++){
            sum += nums[high];

            while(sum >= target){
                minlen = Math.min(minlen, high - low +1);
                sum -= nums[low];
                low++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}