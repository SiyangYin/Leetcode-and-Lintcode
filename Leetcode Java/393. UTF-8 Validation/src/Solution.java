public class Solution {
    public boolean validUtf8(int[] data) {
        // Write your code here
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
        int[] d = {145};
        System.out.println(Integer.toBinaryString(d[0]));
        System.out.println(new Solution().validUtf8(d));
        
        System.out.println("===========================");
        
        int[] dd = {39, 89, 227, 83, 132, 95, 10, 0};
        System.out.println(new Solution().validUtf8(dd));
        for (int i = 0; i < dd.length; i++) {
            System.out.println(Integer.toBinaryString(dd[i]));
        }
        
    }
}
