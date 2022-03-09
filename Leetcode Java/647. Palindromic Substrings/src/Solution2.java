public class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("$#");
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i)).append('#');
        }
        char[] chs = sb.append('^').toString().toCharArray();
        int[] p = new int[chs.length];
        
        int res = 0, mr = 0, mid = 0;
        for (int i = 1; i < chs.length - 1; i++) {
            if (i < mr) {
                p[i] = Math.min(p[2 * mid - i], mr - i);
            } else {
                p[i] = 1;
            }
            
            while (chs[i - p[i]] == chs[i + p[i]]) {
                p[i]++;
            }
            
            if (i + p[i] > mr) {
                mr = i + p[i];
                mid = i;
            }
            
            res += p[i] >> 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().countSubstrings("a"));
        System.out.println(new Solution2().countSubstrings("aa"));
        System.out.println(new Solution2().countSubstrings("aaa"));
    }
}
