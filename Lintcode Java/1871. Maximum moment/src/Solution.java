public class Solution {
    /**
     * @param time: a string of Time
     * @return: The MaximumMoment
     */
    public String MaximumMoment(String time) {
        // write your code here
        char[] chars = time.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0) {
                    chars[0] = chars[1] == '?' || ('0' <= chars[1] && chars[1] <= '3') ? '2' : '1';
                } else if (i == 1) {
                    chars[1] = chars[0] == '2' ? '3' : '9';
                } else if (i == 3) {
                    chars[3] = '5';
                } else if (i == 4) {
                    chars[4] = '9';
                }
            }
        }
        
        return new String(chars);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MaximumMoment("?8:00"));
    }
}
