public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1] % 26;
            shifts[i] %= 26;
        }
    
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            chs[i] += shifts[i] % 26;
            while (chs[i] > 'z') {
                chs[i] -= 26;
            }
        }
        
        return new String(chs);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shiftingLetters("ruu", new int[]{26, 9, 17}));
    }
}
