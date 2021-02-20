import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    
    private int res;
    
    public int findMinStep(String board, String hand) {
        int[] c = new int[5];
        for (int i = 0; i < hand.length(); i++) {
            int j = -1;
            switch (hand.charAt(i)) {
                case 'R': j = 0; break;
                case 'Y': j = 1; break;
                case 'B': j = 2; break;
                case 'G': j = 3; break;
                case 'W': j = 4; break;
            }
            
            c[j]++;
        }
        
        res = hand.length() + 1;
        dfs(board, c, 0, new HashSet<>());
        return res == hand.length() + 1 ? -1 : res;
    }
    
    private void dfs(String board, int[] c, int count, Set<String> set) {
        if (count >= res) {
            return;
        }
        
        if (board.isEmpty()) {
            res = Math.min(res, count);
            return;
        }
        
        String st = board + Arrays.toString(c);
        if (set.contains(st)) {
            return;
        }
        
        set.add(st);
        
        for (int i = 0; i <= board.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (c[j] == 0) {
                    continue;
                }
                
                char color = 0;
                switch (j) {
                    case 0: color = 'R'; break;
                    case 1: color = 'Y'; break;
                    case 2: color = 'B'; break;
                    case 3: color = 'G'; break;
                    case 4: color = 'W'; break;
                }
                
                String nextBoard = board.substring(0, i) + color + board.substring(i);
                c[j]--;
                dfs(remove(nextBoard), c, count + 1, set);
                c[j]++;
            }
        }
    }
    
    private String remove(String s) {
        if (s.length() < 3) {
            return s;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            
            if (j - i >= 3) {
                return remove(s.substring(0, i) + s.substring(j));
            }
        }
        
        return s;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMinStep("WWRRBBWW", "WRBRW"));
    }
}