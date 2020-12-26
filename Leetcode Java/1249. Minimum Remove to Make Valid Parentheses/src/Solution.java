public class Solution {
    public String minRemoveToMakeValid(String s) {
        int l = 0, r = 0;
        
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '(' && str[i] != ')') {
                continue;
            }
            
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            
            if (l < r) {
                str[i] = ' ';
                r--;
            }
        }
     
        int del = l - r;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                if (str[i] == '(' && del > 0) {
                    del--;
                }else {
                    sb.append(str[i]);
                }
            }
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new Solution().minRemoveToMakeValid("))(("));
    }
}
