public class Solution {
//    public boolean canWinNim(int n) {
//        boolean[] win = new boolean[n + 1];
//        if (n == 1 || n == 2 || n == 3) {
//            return true;
//        }
//        win[1] = true;
//        win[2] = true;
//        win[3] = true;
//        for (int i = 4; i <= n; i++) {
//            win[i] = !(win[i - 1] && win[i - 2] && win[i - 3]);
//        }
//        return win[n];
//    }
    
//    public boolean canWinNim(int n) {
//        if (n == 1 || n == 2 || n == 3) {
//            return true;
//        }
//        boolean win1 = true;
//        boolean win2 = true;
//        boolean win3 = true;
//        boolean win4 = false;
//        for (int i = 4; i <= n; i++) {
//            win4 = !(win1 && win2 && win3);
//            win1 = win2;
//            win2 = win3;
//            win3 = win4;
//        }
//        return win4;
//    }
    
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canWinNim(6));
    }
}
