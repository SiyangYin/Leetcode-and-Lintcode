public class Solution {
    /*
     * @param n: a positive integer
     * @return: a positive integer or -1
     */
    public int getPrev(int n) {
        // write your code here
        char[] num = Integer.toBinaryString(n).toCharArray();
        int i = num.length - 1;
        while (i > 0 && num[i - 1] <= num[i]) {
            i--;
        }
        
        if (i == 0) {
            return -1;
        }
        
        int j = num.length - 1;
        while (j > 0 && num[j] == '1') {
            j--;
        }
        
        swap(num, i - 1, j);
        reverse(num, i, num.length - 1);
        return Integer.parseInt(new String(num), 2);
    }
    
    /*
     * @param n: a positive integer
     * @return: a positive integer or -1
     */
    public int getNext(int n) {
        // write your code here
        
        char[] num = ("0" + Integer.toBinaryString(n)).toCharArray();
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) {
            i--;
        }
        int j = num.length - 1;
        while (j > 0 && num[j] == '0') {
            j--;
        }
        
        swap(num, i - 1, j);
        reverse(num, i, num.length - 1);
        long res = Long.parseLong(new String(num), 2);
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
    
    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            swap(str, i, j);
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getNext(2147483647));
        System.out.println(new Solution().getPrev(5));
        
        
        System.out.println(new Solution().getNext(6));
        System.out.println(new Solution().getPrev(6));
    }
}
