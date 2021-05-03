public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res1 = 'z' + 1, res2 = 'z' + 1;
        for (char l : letters) {
            if (l > target) {
                res1 = (char) Math.min(res1, l);
            }
            res2 = (char) Math.min(res2, l);
        }
    
        return res1 == 'z' + 1 ? res2 : res1;
    }
}
