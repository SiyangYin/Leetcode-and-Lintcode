import java.util.PriorityQueue;

public class Solution {
    public String reorganizeString(String S) {
        char[] str = new char[S.length()];
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> -Integer.compare(count[c1 - 'a'], count[c2 - 'a']));
        for (char ch = 'a'; ch <= 'z'; ch++) {
            maxHeap.offer(ch);
        }
        
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            char max = maxHeap.poll();
            while (count[max - 'a'] > 0) {
                str[idx] = max;
                count[max - 'a']--;
                idx += 2;
                if (idx >= str.length) {
                    idx = 1;
                }
            }
        }
    
        for (int i = 1; i < str.length; i++) {
            if (str[i] == str[i - 1]) {
                return "";
            }
        }
        
        return new String(str);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aaab"));
        System.out.println(new Solution().reorganizeString("aab"));
        System.out.println(new Solution().reorganizeString("vvvlo"));
    }
}
