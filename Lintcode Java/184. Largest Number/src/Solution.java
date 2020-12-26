import java.util.Arrays;

public class Solution {
    /**
     * @param nums: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] nums) {
        // write your code here
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
    
        Arrays.sort(numbers, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(number);
        }
     
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        
        if (i == sb.length()) {
            return "0";
        } else {
            return sb.substring(i);
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().largestNumber(new int[]{1, 20, 23, 4, 8}));
        // System.out.println(new Solution().largestNumber(new int[]{4, 6, 65}));
        System.out.println(new Solution().largestNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
