public class Solution {
    /**
     * @param words: the words
     * @param S:     the string
     * @return: the string with least number of tags
     */
    public String boldWords(String[] words, String S) {
        // Write your code here
        int[] diff = new int[S.length() + 1];
        for (String p : words) {
            int[] ne = getNext(p);
            for (int pos = 0;(pos = index(S, p, pos, ne)) != -1; pos++) {
                diff[pos]++;
                diff[pos + p.length()]--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int sum = 0, pre = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum > 0 && pre == 0) {
                sb.append("<b>");
            } else if (sum == 0 && pre > 0) {
                sb.append("</b>");
            }
            
            pre += diff[i];
            if (i < S.length()) {
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    private int index(String s, String p, int start, int[] ne) {
        for (int i = start, j = 0; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == p.length()) {
                    return i - j;
                }
            } else {
                j = ne[j];
            }
        }
        
        return -1;
    }
    
    private int[] getNext(String p) {
        int[] ne = new int[p.length()];
        for (int i = 0, j = ne[0] = -1; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                ne[i] = p.charAt(i) != p.charAt(j) ? j : ne[j];
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
    
    public static void main(String[] args) {
        String[] w = {"ab", "cd"};
        String s = "aabcd";
        System.out.println(new Solution().boldWords(w, s));
    }
}
