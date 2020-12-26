public class Solution {
    /**
     * @param num: an integer
     * @return: convert the integer to hexadecimal
     */
    public String toHex(int num) {
        // Write your code here
        if (num < 0) {
            return compute(((long) 1 << 32) + num);
        } else {
            return compute(num);
        }
    }
    
    private String compute(long num) {
        char[] chs = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(chs[(int) (num % 16)]);
            num /= 16;
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().toHex(26));
        System.out.println(new Solution().toHex(-1));
        System.out.println(Long.toBinaryString((long) Integer.MAX_VALUE + 1));
        System.out.println("10000000000000000000000000000000".length());
    }
}
