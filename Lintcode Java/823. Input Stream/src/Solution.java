public class Solution {
    /**
     * @param inputA: Input stream A
     * @param inputB: Input stream B
     * @return: The answer
     */
    public String inputStream(String inputA, String inputB) {
        // Write your code here
        return parse(inputA).equals(parse(inputB)) ? "YES" : "NO";
    }
    
    private String parse(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != '<') {
                sb.append(ch);
            } else {
                if (sb.length() >= 1) {
                    sb.setLength(sb.length() - 1);
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().inputStream("a<<bc", "abc<"));
    }
}
