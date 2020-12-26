public class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lo++;
                hi++;
            } else if (ch == ')') {
                lo--;
                hi--;
            } else {
                lo--;
                hi++;
            }
            
            lo = Math.max(lo, 0);
            
            if (hi < 0) {
                return false;
            }
        }
        
        return lo == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("()"));
        System.out.println(new Solution().checkValidString("(*)"));
        System.out.println(new Solution().checkValidString("((*)"));
        System.out.println(new Solution().checkValidString("(*))"));
        System.out.println(new Solution().checkValidString("(*()"));
        System.out.println(new Solution().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(new Solution().checkValidString("((*)(*))((*"));
        System.out.println(new Solution().checkValidString("((*)(*))((*)"));
    }
}
