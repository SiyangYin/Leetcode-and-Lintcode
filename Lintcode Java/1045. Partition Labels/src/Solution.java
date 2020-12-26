import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param S: a string
     * @return: a list of integers representing the size of these parts
     */
    public List<Integer> partitionLabels(String S) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            end = Math.max(map.get(ch), end);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
