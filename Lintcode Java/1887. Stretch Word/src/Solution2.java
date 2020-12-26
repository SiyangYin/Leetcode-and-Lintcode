public class Solution2 {
    public long StretchWord(String s) {
        long res = 1L;
        for (int i = 0, j = 0; i != s.length() - 1; i++) {
            final char ci = s.charAt(i);
            while (j + 1 != s.length() - 1 && s.charAt(j + 1) == ci) {
                j++;
            }
            if (j - i >= 1) {
                res <<= 1;
            }
            i = j;
        }
    
        System.out.println("haha");
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().StretchWord("hellloo"));
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
