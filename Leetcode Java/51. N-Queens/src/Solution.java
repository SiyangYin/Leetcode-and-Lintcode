import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(3));
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        
        int[] pos = new int[n];
        helper(pos, 0, res);
        
        return res;
    }
    
    private void helper(int[] pos, int k, List<List<String>> res) {
        if (k == pos.length) {
            res.add(buildBoard(pos));
            return;
        }
    
        for (int i = 0; i < pos.length; i++) {
            if (check(pos, k, i)) {
                pos[k] = i;
                helper(pos, k + 1, res);
            }
        }
    }
    
    // 正在摆第k行的第i个位置
    private boolean check(int[] pos, int k, int i) {
        for (int dif = 1; dif <= k; dif++) {
            if (i - dif >= 0 && pos[k - dif] == i - dif) {
                return false;
            }
            if (i + dif <= pos.length && pos[k - dif] == i + dif) {
                return false;
            }
            if (pos[k - dif] == i) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> buildBoard(int[] pos) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(pos.length);
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos.length; j++) {
                if (j != pos[i]) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            list.add(sb.toString());
            sb.setLength(0);
        }
        return list;
    }
}
