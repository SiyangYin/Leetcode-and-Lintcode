public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int four = num & ((1 << 4) - 1);
            num >>>= 4;
            if (four < 10) {
                sb.append(four);
            } else {
                sb.append((char) ('a' + (four - 10)));
            }
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().toHex(26));
        System.out.println(new Solution().toHex(-1));
    }
}
