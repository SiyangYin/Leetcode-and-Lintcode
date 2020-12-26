import javax.xml.stream.FactoryConfigurationError;

public class Solution2 {
    /**
     * @param data: an array of integers
     * @return: whether it is a valid utf-8 encoding
     */
    public boolean validUtf8(int[] data) {
        // Write your code here
        if (data == null || data.length == 0) {
            return false;
        }
        
        int idx = 0;
        while (true) {
            int[] nums = check(data, idx);
            if (nums[0] == 0) {
                return false;
            }
            
            idx = nums[1];
            if (idx >= data.length) {
                return true;
            }
        }
    }
    
    private int[] check(int[] data, int idx) {
        int first = data[idx];
        if (((first >> 7) & 1) == 0) {
            return new int[]{1, idx + 1};
        }
        
        int count = 0;
        for (int i = 7; i >= 0; i--) {
            if (((first >> i) & 1) == 1) {
                count++;
            } else {
                break;
            }
        }
        
        if (count >= 5) {
            return new int[]{0};
        }
        
        if (data.length - idx < count) {
            return new int[]{0};
        }
        
        for (int i = idx + 1; i < idx + count; i++) {
            if (((data[i] >> 6) & 0b10) != 0b10) {
                return new int[]{0};
            }
        }
        
        return new int[]{1, idx + count};
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().validUtf8(new int[]{197, 130, 1}));
        // System.out.println(new Solution2().validUtf8(new int[]{235, 140, 4}));
        int[] ns = {250,145,145,145,145};
        for (int n : ns) {
            System.out.print(Integer.toBinaryString(n) + " ");
        }
        System.out.println(new Solution2().validUtf8(new int[]{250,145,145,145,145}));
    }
}
