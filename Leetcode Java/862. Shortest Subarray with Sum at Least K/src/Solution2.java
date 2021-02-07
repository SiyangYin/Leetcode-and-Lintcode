public class Solution2 {
    public int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        int[] stack = new int[A.length + 1];
        int res = A.length + 1, top = 0;
        for (int i = 0; i < preSum.length; i++) {
            // 枚举以preSum[i]为右端点的子区间。这里可以直接把大于等于preSum[i]
            // 的栈顶pop掉的原因有二，一是K是正的，能作为左端点的preSum一定比
            // preSum[i]更小；其二是，在本轮循环结束之后，那些大于等于preSum[i]
            // 的preSum不可能是最优的左端点，因为它们更大，而且更左
            while (top > 0 && preSum[stack[top - 1]] >= preSum[i]) {
                top--;
            }
            
            // 栈里存的是左端点的备选，由于栈已经单调增了，所以可以二分查找最右边的
            // 可以作为左端点的位置；如果栈空，则说明没有任何左端点满足条件
            if (top > 0) {
                int l = 0, r = top - 1;
                while (l < r) {
                    int m = l + (r - l + 1 >> 1);
                    if (preSum[i] - preSum[stack[m]] >= K) {
                        l = m;
                    } else {
                        r = m - 1;
                    }
                }
                
                // 如果找到了就更新答案
                if (preSum[i] - preSum[stack[l]] >= K) {
                    res = Math.min(res, i - stack[l]);
                }
            }
            
            stack[top++] = i;
        }
        
        return res == A.length + 1 ? -1 : res;
    }
}
