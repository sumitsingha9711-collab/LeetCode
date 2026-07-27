class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int left = -1;
        int right = -1;

        int maxseen = nums[0];

        for(int i = 1; i<= n-1; i++){
            if (nums[i] < maxseen)
                right = i;
            else
                maxseen = nums[i];
        }

        if(right == -1)
            return 0;

        int minseen = nums[n-1];

        for(int i = n-2; i >= 0; i--){
            if(nums[i] > minseen)
                left = i;
            else
                minseen = nums[i];  
        }

        return right - left + 1;
    }
}