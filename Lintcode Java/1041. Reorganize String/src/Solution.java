import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String reorganizeString(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> {
            if (count[c1 - 'a'] != count[c2 - 'a']) {
                return -Integer.compare(count[c1 - 'a'], count[c2 - 'a']);
            } else {
                return Character.compare(c1, c2);
            }
        });
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }
        
        List<Character> list = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                
                char ch = maxHeap.poll();
                sb.append(ch);
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
                    return "";
                }
                
                count[ch - 'a']--;
                if (count[ch - 'a'] > 0) {
                    list.add(ch);
                }
            }
            
            maxHeap.addAll(list);
            list.clear();
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().reorganizeString("aab"));
        // System.out.println(new Solution().reorganizeString("aabb"));
        // System.out.println(new Solution().reorganizeString("aabbaa"));
        // System.out.println(new Solution().reorganizeString("vvvlo"));
        // System.out.println(new Solution().reorganizeString("aaab"));
        System.out.println(new Solution().reorganizeString("aab"));
    }
}
