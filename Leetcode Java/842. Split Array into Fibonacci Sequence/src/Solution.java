import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 1; i < s.length(); i++) {
            for (int len = 1; i + len - 1 < s.length(); len++) {
                int a = 0, b = i, c = b + len;
                String n = s.substring(a, b);
                if (!check(n) || !check(s.substring(b, c))) {
                    break;
                }
                
                res.add((Integer.parseInt(n)));
                while (true) {
                    if (s.charAt(a) == '0' && b - a != 1) {
                        break;
                    }
                    if (s.charAt(b) == '0' && c - b != 1) {
                        break;
                    }
                    
                    String n1 = s.substring(a, b), n2 = s.substring(b, c);
                    if (!check(n1) || (!check(n2) && c != s.length())) {
                        break;
                    }
                    
                    res.add(Integer.parseInt(n2));
                    a = b;
                    b = c;
                    
                    String next = add(n1, n2);
                    c = c + next.length();
                    
                    if (b == s.length()) {
                        if (res.size() > 2) {
                            return res;
                        } else {
                            break;
                        }
                    }
                    
                    if (b + next.length() > s.length()) {
                        break;
                    }
                    
                    if (!next.equals(s.substring(b, b + next.length()))) {
                        break;
                    }
                }
                
                res.clear();
            }
        }
        
        return res;
    }
    
    private String add(String n1, String n2) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int i = n1.length() - 1, j = n2.length() - 1; i >= 0 || j >= 0; ) {
            int x = 0, y = 0;
            if (i >= 0) {
                x = n1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                y = n2.charAt(j) - '0';
                j--;
            }
            
            n += x + y;
            sb.append(n % 10);
            n /= 10;
        }
        
        if (n == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
    private boolean check(String n) {
        String max = "2147483647";
        if (n.length() != max.length()) {
            return n.length() < max.length();
        }
    
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) > max.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().add("123", "444"));
    
        // System.out.println(new Solution().check("2147483648"));
    
        System.out.println(new Solution().splitIntoFibonacci("11235813"));
        System.out.println(new Solution().splitIntoFibonacci("0123"));
        System.out.println(new Solution().splitIntoFibonacci("214748364721474836422147483641"));
        System.out.println(new Solution().splitIntoFibonacci("417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755"));
    }
}
