public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mchs = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            mchs[magazine.charAt(i) - 'a']++;
        }
    
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            mchs[idx]--;
            if (mchs[idx] < 0) {
                return false;
            }
        }
        return true;
    }
}
