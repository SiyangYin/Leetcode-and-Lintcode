public class Solution {
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int j = i;
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                
                i = j;
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("hello, my name is john"));
    }
}
