public class Solution {
    /**
     * @param Spell: The Spell
     * @return: nothing
     */
    public char holyGrailspell(String Spell) {
        // Write your code here
        boolean[] exista = new boolean[26], existA = new boolean[26];
        for (int i = 0; i < Spell.length(); i++) {
            char ch = Spell.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                exista[ch - 'a'] = true;
            } else {
                existA[ch - 'A'] = true;
            }
        }
    
        for (int i = 25; i >= 0; i--) {
            if (exista[i] && existA[i]) {
                return (char) ('A' + i);
            }
        }
        
        return 0;
    }
}
