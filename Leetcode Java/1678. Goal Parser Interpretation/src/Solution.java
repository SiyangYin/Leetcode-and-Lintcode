public class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                sb.append('G');
            } else {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i = i + 3;
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().interpret("G()(al)"));
    }
}
