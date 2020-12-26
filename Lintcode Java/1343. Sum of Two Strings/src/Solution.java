public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return the sum of two strings
     */
    public String SumofTwoStrings(String A, String B) {
        // write your code here
        if (A.length() < B.length()) {
            String c = A;
            A = B;
            B = c;
        }
        
        StringBuilder sb = new StringBuilder();
        int offset = A.length() - B.length();
        for (int i = 0; i < offset; i++) {
            sb.append(A.charAt(i));
        }
        
        for (int i = 0; i < B.length(); i++) {
            char c1 = A.charAt(i + offset), c2 = B.charAt(i);
            sb.append(c1 - '0' + c2 - '0');
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().SumofTwoStrings("99", "111"));
        System.out.println(new Solution().SumofTwoStrings("2", "321"));
    }
}
