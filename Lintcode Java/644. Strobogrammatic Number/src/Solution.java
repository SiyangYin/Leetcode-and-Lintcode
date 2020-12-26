public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
        int l = 0, r = num.length() - 1;
        while (l < r) {
            if (!rotate(num.charAt(l) - '0', num.charAt(r) - '0')) {
                return false;
            }
            l++;
            r--;
        }
        if (l == r) {
            char c = num.charAt(l);
            return c == '0' || c == '1' || c == '8';
        } else {
            return true;
        }
    }
    
    private boolean rotate(int x, int y) {
        switch (x) {
            case 0:
                return y == 0;
            case 1:
                return y == 1;
            case 2:
                return y == 5;
            case 5:
                return y == 2;
            case 6:
                return y == 9;
            case 8:
                return y == 8;
            case 9:
                return y == 6;
            default:
                return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isStrobogrammatic("69"));
    }
}
