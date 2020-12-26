import java.util.Arrays;

public class Solution {
    /**
     * @param nums: n non-negative integer array
     * @return: A string
     */
    public String minNumber(int[] nums) {
        // write your code here
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
    
        Arrays.sort(numbers, (n1, n2) -> (n1 + n2).compareTo(n2 + n1));
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(number);
        }
        
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        
        return i == sb.length() ? "0" : sb.substring(i);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minNumber(new int[]{3, 32, 321}));
    }
}
