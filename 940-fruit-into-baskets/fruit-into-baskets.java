class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int Maxlen = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for(int right = 0; right < n; right++){
            freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);

            while(freq.size() > 2){
                int Leftfruit = fruits[left];
                freq.put(Leftfruit, freq.get(Leftfruit) - 1);
                if(freq.get(Leftfruit) == 0)
                    freq.remove(Leftfruit);
                left++;
            }
            Maxlen = Math.max(Maxlen, right - left +1);
        }

        return Maxlen;

    }
}