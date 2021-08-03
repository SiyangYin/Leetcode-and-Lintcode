public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[2];
        for (int x : bills) {
            if (x == 5) {
                cnt[0]++;
            } else if (x == 10) {
                if (cnt[0] == 0) {
                    return false;
                }
                cnt[0]--;
                cnt[1]++;
            } else {
                if (cnt[0] > 0 && cnt[1] > 0) {
                    cnt[0]--;
                    cnt[1]--;
                } else if (cnt[0] >= 3) {
                    cnt[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
