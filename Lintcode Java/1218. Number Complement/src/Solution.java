public class Solution {
    /**
     * @param num: an integer
     * @return: the complement number
     */
    public int findComplement(int num) {
        // Write your code here
        int len = 0, tmp = num;
        while (tmp != 0) {
            len++;
            tmp >>= 1;
        }
        
        return (1 << len) - 1 - num;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
    }
}
