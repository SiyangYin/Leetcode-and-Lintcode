public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 6};
        System.out.println(new Solution().judgePoint24(nums));
    }
    
    public boolean judgePoint24(int[] nums) {
        double[] b = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            b[i] = nums[i];
        }
        return myJudge(b, nums.length);
    }
    
    public boolean myJudge(double[] nums, int n) {
        if (n == 1) {
            return is0(nums[0] - 24);
        }
            double[] b = new double[4];
            int m = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            b[m++] = nums[k];
                        }
                    }
                    b[m] = nums[i] + nums[j];
                    if (myJudge(b, m + 1)) {
                        return myJudge(b, m + 1);
                    }
                    b[m] = nums[i] - nums[j];
                    if (myJudge(b, m + 1)) {
                        return myJudge(b, m + 1);
                    }
                    b[m] = nums[j] - nums[i];
                    if (myJudge(b, m + 1)) {
                        return myJudge(b, m + 1);
                    }
                    b[m] = nums[i] * nums[j];
                    if (myJudge(b, m + 1)) {
                        return myJudge(b, m + 1);
                    }
                    if (!is0(nums[j])) {
                        b[m] = nums[i] / nums[j];
                        if (myJudge(b, m + 1)) {
                            return myJudge(b, m + 1);
                        }
                    }
                    if (!is0(nums[i])) {
                        b[m] = nums[j] / nums[i];
                        if (myJudge(b, m + 1)) {
                            return myJudge(b, m + 1);
                        }
                    }
                }
            }
            return false;
        
    }
    
    public boolean is0(double x) {
        return Math.abs(x) < 1e-10;
    }
}
