class Solution {
    public int removeDuplicates(int[] num) {
        int unique = 1;
        int low = 0;
        int high = 1;
        int k = num.length;

        while (high < k){
            if (num[high] == num[high-1]){
                high++;
                continue;
            }

            num[low+1] = num[high];
            unique++;
            low++;
            high++;
        }

        return unique;
    }
}