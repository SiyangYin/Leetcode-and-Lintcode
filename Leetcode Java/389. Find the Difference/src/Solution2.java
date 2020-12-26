public class Solution2 {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i) ^ t.charAt(i);
        }
        return (char) (c ^ t.charAt(s.length()));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("abcdss", "abcedss"));
    }
}
