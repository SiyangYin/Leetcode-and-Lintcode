public class Solution {
    /**
     * @param S: the string
     * @return: nothing
     */
    public long StretchWord(String S) {
        // write your code here
        long res = 1;
        for (int i = 0; i < S.length(); ) {
            int j = i;
            for (; j < S.length() && S.charAt(i) == S.charAt(j); j++) {
            
            }
            
            if (j - i > 2) {
                res *= 2;
            }
            
            i = j;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().StretchWord("hellloo"));
        String S = "sxswdjlpvrujefnpnjkmgoujdodbawzwlschyaxdctvsxwlxzduacjqhquvlexqfsxqdrvlhwumjrhxglmnnsfejdolrxmcnbbehmkcuppzinlhiwihjfjuztgcxfcsagqrvqnyodljqopvuuejlpftqdnqapf";
        for (int i = 0; i < S.length(); ) {
            int j = i;
            for (; j < S.length() && S.charAt(i) == S.charAt(j); j++) {
            
            }
        
            if (j - i > 2) {
                System.out.println(i + "  " + S.charAt(i));
            }
        
            i = j;
        }
    }
}
