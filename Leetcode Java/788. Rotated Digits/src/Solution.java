public class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (check(i)) {
                res++;
            }
        }
    
        return res;
    }
    
    private boolean check(int n) {
        boolean found = false;
        while (n != 0) {
            int last = n % 10;
            if (last == 3 || last == 4 || last == 7) {
                return false;
            }
            if (last == 2 || last == 5 || last == 6 || last == 9) {
                found = true;
            }
            
            n /= 10;
        }
        
        return found;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(20));
    }
}
