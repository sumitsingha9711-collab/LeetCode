import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                neg.add(nums[i]);
            else
                pos.add(nums[i]);
        }

        // Case 1: No negative numbers
        if (neg.size() == 0) {
            for (int i = 0; i < pos.size(); i++) {
                pos.set(i, pos.get(i) * pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }

        // Case 2: No positive numbers
        if (pos.size() == 0) {
            for (int i = 0; i < neg.size(); i++) {
                neg.set(i, neg.get(i) * neg.get(i));
            }

            Collections.reverse(neg);

            return neg.stream().mapToInt(Integer::intValue).toArray();
        }

        int n1 = neg.size();
        int n2 = pos.size();

        // Square negatives
        for (int i = 0; i < n1; i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }

        Collections.reverse(neg);

        // Square positives
        for (int i = 0; i < n2; i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }

        int[] result = new int[n1 + n2];

        int i = 0, j = 0, id = 0;

        // Merge two sorted lists
        while (i < n1 && j < n2) {
            if (neg.get(i) <= pos.get(j))
                result[id++] = neg.get(i++);
            else
                result[id++] = pos.get(j++);
        }

        while (i < n1) {
            result[id++] = neg.get(i++);
        }

        while (j < n2) {
            result[id++] = pos.get(j++);
        }

        return result;
    }
}