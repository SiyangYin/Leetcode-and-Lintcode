import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            res.add(0L);
        }
        
        int zeroIdx = -1, zeroCount = 0;
        long product = 1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != 0) {
                product *= nums.get(i);
            } else {
                zeroCount++;
                zeroIdx = i;
            }
        }
        
        if (zeroCount > 1) {
            Collections.fill(res, 0L);
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.size(); i++) {
                if (i != zeroIdx) {
                    res.set(i, 0L);
                } else {
                    res.set(i, product);
                }
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                res.set(i, product / nums.get(i));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().productExcludeItself(new ArrayList<>(){{
            add(2);
            add(4);
            add(6);
        }}));
    }
}