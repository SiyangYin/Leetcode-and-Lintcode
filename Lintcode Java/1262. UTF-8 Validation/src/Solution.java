public class Solution {
    /**
     * @param data: an array of integers
     * @return: whether it is a valid utf-8 encoding
     */
    public boolean validUtf8(int[] data) {
        // Write your code here
        if (data == null || data.length == 0) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (count > 0) {
                if (data[i] >> 6 != 0b10) {
                    return false;
                }
                count--;
            } else if (data[i] >> 7 == 0) {
                count = 0;
            } else if (data[i] >> 5 == 0b110) {
                count = 1;
            } else if (data[i] >> 4 == 0b1110) {
                count = 2;
            } else if (data[i] >> 3 == 0b11110) {
                count = 3;
            } else {
                return false;
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
        // System.out.println(Integer.toBinaryString(130));
        int[] ns = {250,145,145,145,145};
        for (int n : ns) {
            System.out.print(Integer.toBinaryString(n) + " ");
        }
        System.out.println(new Solution().validUtf8(new int[]{250,145,145,145,145}));
    
    }
}
