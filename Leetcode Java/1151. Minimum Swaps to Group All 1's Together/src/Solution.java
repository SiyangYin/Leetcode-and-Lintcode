public class Solution {
    public int minSwaps(int[] data) {
        int res = 0;
        for (int x : data) {
            res += x;
        }
        
        int cnt = res, sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += data[i];
        }
        
        res = Math.min(res, cnt - sum);
        for (int i = cnt; i < data.length; i++) {
            sum += data[i] - data[i - cnt];
            res = Math.min(res, cnt - sum);
        }
        
        return res;
    }
}
