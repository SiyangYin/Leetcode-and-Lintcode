public class Solution {
    public int countValidWords(String sentence) {
        String[] ss = sentence.split("\\s+");
        int res = 0;
        for (String s : ss) {
            if (!s.isEmpty() && check(s)) {
                res++;
            }
        }
        
        return res;
    }
    
    boolean check(String s) {
        int h = 0, m = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            
            if (Character.isDigit(ch[i]) || ch[i] == ' ') {
                return false;
            }
            if (ch[i] == '-') {
                h++;
                if (h >= 2) return false;
                else if (i == 0 || i == ch.length - 1 || !Character.isLetter(ch[i - 1]) || !Character.isLetter(ch[i + 1]))
                    return false;
            }
            if (ch[i] == '!' || ch[i] == '.' || ch[i] == ',') {
                m++;
                if (m >= 2) return false;
                if (i != ch.length - 1) return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().countValidWords("cat and  dog"));
        System.out.println(new Solution().countValidWords("!"));
//        System.out.println(new Solution().countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }
}
