public class Solution {
    /**
     * @param N: a positive number
     * @return: how many numbers X from 1 to N are good
     */
    public int rotatedDigits(int N) {
        // write your code here
        char[] rot = {'0', '1', '5', 0, 0, '2', '9', 0, '8', '6'};
        
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (check(String.valueOf(i), rot)) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean check(String s, char[] rot) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (rot[ch - '0'] != 0) {
                sb.append(rot[ch - '0']);
            } else {
                return false;
            }
        }
        
        return !sb.toString().equals(s);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(10));
    }
}
