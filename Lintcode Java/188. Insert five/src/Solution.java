public class Solution {
    /**
     * @param a: A number
     * @return: Returns the maximum number after insertion
     */
    public int InsertFive(int a) {
        // write your code here
        // if (a == 0) {
        //     return 50;
        // }
        
        int b = Math.abs(a);
        StringBuilder sb = new StringBuilder(String.valueOf(b));
        int len = sb.length();
        
        if (a >= 0) {
            for (int i = 0; i < len; i++) {
                if (sb.charAt(i) <= '5') {
                    sb.insert(i, '5');
                    break;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (sb.charAt(i) >= '5') {
                    sb.insert(i, '5');
                    break;
                }
            }
        }
        if (sb.length() == len) {
            sb.append(5);
        }
        
        int res = Integer.parseInt(sb.toString());
        return a >= 0 ? res : -res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().InsertFive(234));
        System.out.println(new Solution().InsertFive(-234));
        System.out.println(new Solution().InsertFive(0));
        
    }
}
