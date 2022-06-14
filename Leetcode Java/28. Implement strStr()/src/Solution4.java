import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public int strStr(String s, String p) {
        if (p.isEmpty()) {
            return 0;
        }
        
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        
        int[] ne = buildNe(p, m);
        for (int i = 1, j = 0; i <= n; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j + 1)) {
                j = ne[j];
            }
            if (s.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            
            if (j == m) {
                return i - m;
            }
        }
        
        return -1;
    }
    
    private int[] buildNe(String p, int m) {
        int[] ne = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j + 1)) {
                j = ne[j];
            }
            if (p.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            ne[i] = i < m && p.charAt(i + 1) != p.charAt(j + 1) ? j : ne[j];
        }
    
        return ne;
    }
    
    public static void main(String[] args) {
        String p = "aabaaac";
        int[] ne = new Solution4().buildNe((" " + p), p.length());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < ne.length; i++) {
            list.add(ne[i]);
        }
        
        System.out.println(list);
        
        String s= "aabaaabaaac";
        System.out.println(new Solution4().strStr(s, p));
    }
}
