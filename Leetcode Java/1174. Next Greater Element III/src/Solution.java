public class Solution {
    /**
     * @param n: an integer
     * @return: the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n
     */
    public int nextGreaterElement(int n) {
        // Write your code here
        char[] num = String.valueOf(n).toCharArray();
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) {
            i--;
        }
        
        if (i == 0) {
            return -1;
        }
    
        int pos = binarySearch(num, i, num[i - 1]);
        swap(num, i - 1, pos);
        reverse(num, i, num.length - 1);
    
        long res = Long.parseLong(new String(num));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
    
    private int binarySearch(char[] num, int idx, char target) {
        int l = idx, r = num.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (num[m] > target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
    
    private void reverse(char[] num, int i, int j) {
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(char[] num, int i, int j) {
        char tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().nextGreaterElement(12));
        // System.out.println(new Solution().nextGreaterElement(21));
        // System.out.println(new Solution().nextGreaterElement(123));
        System.out.println(new Solution().nextGreaterElement(1999999999));
    }
}
