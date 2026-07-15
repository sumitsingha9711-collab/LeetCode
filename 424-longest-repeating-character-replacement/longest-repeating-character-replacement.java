class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increase frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update the maximum frequency in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If replacements needed are more than k, shrink the window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}