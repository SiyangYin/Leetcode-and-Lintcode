public class Solution {
    public int binaryGap(int N) {
        int res = 0;
        String s = Integer.toBinaryString(N);
        for (int i = 0, j = 0; i < s.length(); ) {
            if (s.charAt(i) == '0') {
                continue;
            }
            
            j = i + 1;
            while (j < s.length() && s.charAt(j) != '1') {
                j++;
            }
            if (j == s.length()) {
                break;
            }
            
            res = Math.max(res, j - i);
            i = j;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().binaryGap(13));
        System.out.println(new Solution().binaryGap(22));
    }
}
