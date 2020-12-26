public class Solution {
    /**
     * @param S: The given string S
     * @param T: The given string T
     * @return: any permutation of T (as a string) that satisfies this property
     */
    public String customSortString(String S, String T) {
        // Write your code here
        int[] count = new int[26];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i) - 'a';
            while (count[idx] > 0) {
                sb.append((char) ('a' + idx));
                count[idx]--;
            }
        }
    
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
    
            for (int j = 0; j < count[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().customSortString("cba", "abcd"));
    }
}
