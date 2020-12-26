public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int u = i, v = j;
            while (u < version1.length() && version1.charAt(u) != '.') {
                u++;
            }
            
            while (v < version2.length() && version2.charAt(v) != '.') {
                v++;
            }
            
            int a = 0, b = 0;
            if (u != i) {
                a = Integer.parseInt(version1.substring(i, u));
            }
            if (v != j) {
                b = Integer.parseInt(version2.substring(j, v));
            }
            
            if (a != b) {
                return Integer.compare(a, b);
            }
            
            i = u + 1;
            j = v + 1;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.1", "1"));
    }
}
