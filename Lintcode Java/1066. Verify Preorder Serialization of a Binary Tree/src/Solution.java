import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param preorder: a string
     * @return: return a bool
     */
    public boolean isValidSerialization(String preorder) {
        // write your code here
        String[] strs = preorder.split(",");
        Deque<String> stk = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (s.equals("#")) {
                while (!stk.isEmpty() && stk.peek().equals("#")) {
                    stk.pop();
                    if (stk.isEmpty()) {
                        return false;
                    }
                    
                    stk.pop();
                }
            }
            
            stk.push(s);
        }
        
        return stk.size() == 1 && stk.peek().equals("#");
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,#,#"));
        System.out.println(new Solution().isValidSerialization("9,#,3,#,4,#,#"));
        System.out.println(new Solution().isValidSerialization("9,#,#,#,#,#"));
    }
}
