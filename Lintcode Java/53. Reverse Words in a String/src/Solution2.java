public class Solution2 {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                sb.append(word.charAt(i));
            }
            sb.append(' ');
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().reverseWords("the   blue sky"));
    }
}
