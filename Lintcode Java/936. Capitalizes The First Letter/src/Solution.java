public class Solution {
    /**
     * @param s: a string
     * @return: a string after capitalizes the first letter
     */
    public String capitalizesFirst(String s) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) {
                sb.append(c);
            } else {
                if (i == 0 || !Character.isLetter(s.charAt(i - 1))) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().capitalizesFirst("i want to get an accepted"));
    }
}
