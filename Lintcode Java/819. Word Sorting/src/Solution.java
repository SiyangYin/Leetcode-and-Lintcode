import java.util.Arrays;

public class Solution {
    /**
     * @param alphabet: the new alphabet
     * @param words: the original string array
     * @return: the string array after sorting
     */
    public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
        int[] order = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            order[alphabet[i] - 'a'] = i;
        }
    
        Arrays.sort(words, (w1, w2) -> {
            for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
                if (order[w1.charAt(i) - 'a'] != order[w2.charAt(i) - 'a']) {
                    return Integer.compare(order[w1.charAt(i) - 'a'], order[w2.charAt(i) - 'a']);
                }
            }
            
            return Integer.compare(w1.length(), w2.length());
        });
        
        return words;
    }
    
    public static void main(String[] args) {
        char[] al = "zbadefghijklmnopqrstuvwxyc".toCharArray();
        String[] w = {"bca","czb","za","zba","ade"};
        System.out.println(Arrays.toString(new Solution().wordSort(al, w)));
    
    }
}
