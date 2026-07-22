class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int first = 0; first <= n-4; first++ ){
            if(first > 0 && nums[first] == nums[first-1])
                continue;

            for(int second = first + 1; second <= n-3; second++){
                if(second > first + 1 && nums[second] == nums[second-1])
                    continue;

                int low = second + 1;
                int high = n - 1;

                while(low < high){
                    long sum = (long) nums[first] + nums[second] + nums[low] + nums[high];

                    if (sum == target){
                        result.add(Arrays.asList(nums[first], nums[second], nums[low], nums[high]));
                        low++;
                        high--;

                        while(low < high && nums[low] == nums[low -1])
                            low++;

                        while(low < high && nums[high] == nums[high + 1])
                            high--;
                    }

                    else if(sum > target)
                        high--;
                    
                    else
                        low++;
                }
            }
        }

        return result;   
    }
}