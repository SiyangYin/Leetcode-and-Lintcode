import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        int a = compute(s), res = 0, len = s.length();
        Set<Integer>[][] f = new Set[len][len];
        dfs(s, 0, len - 1, f);
        Set<Integer> set = f[0][len - 1];
        for (int x : answers) {
            if (a == x) {
                res += 5;
            } else if (set.contains(x)) {
                res += 2;
            }
        }
        
        return res;
    }
    
    Set<Integer> dfs(String s, int l, int r, Set<Integer>[][] f) {
        if (f[l][r] != null) {
            return f[l][r];
        }
        
        f[l][r] = new HashSet<>();
        if (l == r) {
            f[l][r].add(s.charAt(l) - '0');
        } else {
            for (int i = l + 1; i < r; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    for (int x : dfs(s, l, i - 1, f)) {
                        for (int y : dfs(s, i + 1, r, f)) {
                            int res = 0;
                            if (s.charAt(i) == '+') {
                                res = x + y;
                            } else {
                                res = x * y;
                            }
                            
                            if (0 <= res && res <= 1000) {
                                f[l][r].add(res);
                            }
                        }
                    }
                }
            }
        }
        
        return f[l][r];
    }
    
    int compute(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (i > 0 && s.charAt(i - 1) == '*') {
                    stk.push(stk.pop() * (ch - '0'));
                } else {
                    stk.push(ch - '0');
                }
            }
        }
        
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfStudents("7+3*1*2", new int[]{20, 13, 42}));
    }
}
