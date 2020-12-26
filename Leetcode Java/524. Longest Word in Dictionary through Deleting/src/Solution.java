import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String sub : d) {
            if (isSubsequence(s, sub)) {
                if (!pq.isEmpty() && pq.peek().length() < sub.length()) {
                    pq.clear();
                    pq.offer(sub);
                } else if (pq.isEmpty() || pq.peek().length() == sub.length()) {
                    pq.offer(sub);
                }
            }
        }
        
        return pq.isEmpty() ? "" : pq.peek();
    }
    
    private boolean isSubsequence(String s, String sub) {
        int j = 0;
        for (int i = 0; i < s.length() && j < sub.length(); i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }
        
        return j == sub.length();
    }
    
    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        // d.add("ale");
        // d.add("apple");
        // d.add("monkey");
        // d.add("plea");
        
        d.add("zxc");
        d.add("vbn");
        System.out.println(new Solution().findLongestWord("apple", d));
    }
}
