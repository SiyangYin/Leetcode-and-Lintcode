public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        
        int res = num % 9;
        return res == 0 ? 9 : res;
    }
}
