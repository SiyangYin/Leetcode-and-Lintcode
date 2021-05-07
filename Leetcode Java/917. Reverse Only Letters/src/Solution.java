public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        for (int i = 0, j = s.length - 1; i < j; ) {
            while (i < j && !Character.isLetter(s[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(s[j])) {
                j--;
            }
            
            swap(s, i, j);
            i++;
            j--;
        }
        
        return new String(s);
    }
    
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
