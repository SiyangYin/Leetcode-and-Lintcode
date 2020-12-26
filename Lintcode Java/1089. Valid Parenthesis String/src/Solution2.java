public class Solution2 {
    public boolean checkValidString(String s) {
        if (s.isEmpty()) {
            return true;
        }
        
        return dfs(0, s, 0);
    }
    
    private boolean dfs(int pos, String s, int count) {
        if (count < 0 || count > s.length() - pos) {
            return false;
        }
        if (pos == s.length()) {
            return count == 0;
        }
        
        for (int i = pos; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            } else {
                return dfs(i + 1, s, count) || dfs(i + 1, s, count + 1) || dfs(i + 1, s, count - 1);
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().checkValidString("*"));
        System.out.println(new Solution2().checkValidString("()"));
        System.out.println(new Solution2().checkValidString("(*)"));
        System.out.println(new Solution2().checkValidString("((*)"));
        System.out.println(new Solution2().checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
    }
}
