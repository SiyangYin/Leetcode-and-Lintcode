public class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < count.length; j++) {
                if (count[j] > 0) {
                    sb.append((char) ('a' + j));
                    count[j]--;
                    i++;
                }
            }
    
            for (int j = count.length - 1; j >= 0; j--) {
                if (count[j] > 0) {
                    sb.append((char) ('a' + j));
                    count[j]--;
                    i++;
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().sortString("aaaabbbbcccc"));
    }
}
