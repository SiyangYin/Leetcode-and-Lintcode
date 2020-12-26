import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param S: a string S of digits
     * @return: Return any Fibonacci-like sequence split from S
     */
    public List<Integer> splitIntoFibonacci(String S) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i + 1 < S.length(); i++) {
            for (int j = i + 1; j < S.length(); j++) {
                int start1 = 0, end1 = i, end2 = j;
                while (true) {
                    if (end1 - start1 + 1 >= 2 && S.charAt(start1) == '0') {
                        break;
                    }
                    if (end2 - end1 >= 2 && S.charAt(end1 + 1) == '0') {
                        break;
                    }
                    
                    long a = Long.parseLong(S.substring(start1, end1 + 1)), b = Long.parseLong(S.substring(end1 + 1, end2 + 1));
                    if (a > Integer.MAX_VALUE || b > Integer.MAX_VALUE) {
                        break;
                    }
                    
                    long c = a + b;
                    String str = String.valueOf(c);
                    if (S.indexOf(str, end2 + 1) != end2 + 1) {
                        break;
                    }
                    
                    if (start1 == 0) {
                        res.add((int) a);
                    }
                    
                    res.add((int) b);
                    
                    start1 = end1 + 1;
                    end1 = end2;
                    end2 += str.length();
                    
                    if (end2 == S.length() - 1 && res.size() >= 2) {
                        res.add((int) c);
                        return res;
                    }
                }
                
                res.clear();
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().splitIntoFibonacci("123456579"));
        System.out.println(new Solution().splitIntoFibonacci("11235813"));
        System.out.println(new Solution().splitIntoFibonacci("112358130"));
        
        System.out.println(new Solution().splitIntoFibonacci("1101111"));
        System.out.println(("1101111").length());
        // System.out.println("abca".indexOf('a', 3));
    }
}
