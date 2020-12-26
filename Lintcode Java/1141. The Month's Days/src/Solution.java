public class Solution {
    /**
     * @param year: a number year
     * @param month: a number month
     * @return: Given the year and the month, return the number of days of the month.
     */
    public int getTheMonthDays(int year, int month) {
        // write your code here
        int[] nums = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month != 2) {
            return nums[month - 1];
        }
        
        return nums[month - 1] + isLeap(year);
    }
    
    private int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 1 : 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getTheMonthDays(2020, 2));
    }
}
