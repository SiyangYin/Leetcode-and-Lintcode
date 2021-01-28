public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                count[Character.toLowerCase(ch) - 'a']++;
            }
        }
        
        String res = "";
        for (String word : words) {
            int[] curCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                curCount[word.charAt(i) - 'a']++;
            }
            
            if (!check(count, curCount)) {
                continue;
            }
            
            if (res.isEmpty() || word.length() < res.length()) {
                res = word;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count, int[] curCount) {
        for (int i = 0; i < 26; i++) {
            if (curCount[i] < count[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String l = "1s3 PSt";
        String[] w = {"step", "steps", "stripe", "stepple"};
        System.out.println(new Solution().shortestCompletingWord(l, w));
    }
}
