import java.util.Arrays;

public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freqOfWords = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            freqOfWords[i] = func(words[i]);
        }
        Arrays.sort(freqOfWords);
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int freq = func(queries[i]);
            res[i] = freqOfWords.length - binarySearch(freqOfWords, freq);
        }
        
        return res;
    }
    
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (target >= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        if (nums[l] > target) {
            return l;
        } else {
            return l + 1;
        }
    }
    
    private int func(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char ch = 'z' + 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < ch) {
                ch = s.charAt(i);
                count = 0;
            } else if (s.charAt(i) == ch) {
                count++;
            }
        }
        
        return count;
    }
}
