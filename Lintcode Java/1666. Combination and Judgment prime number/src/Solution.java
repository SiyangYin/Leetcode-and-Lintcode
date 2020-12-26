import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param a: the n numbers
     * @param k: the number of integers you can choose
     * @return: how many ways that the sum of the k integers is a prime number
     */
    public int getWays(int[] a, int k) {
        // Write your code here
        if (a == null || a.length == 0) {
            return 0;
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsetsHelper(result, list, a, 0, k);
        int count = 0;
        for (List<Integer> integers : result) {
            if (isPrime(computeSum(integers))) {
                count++;
            }
        }
        return count;
    }
    
    private void subsetsHelper(ArrayList<List<Integer>> result,
                               ArrayList<Integer> list, int[] nums, int startIndex, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1, k);
            list.remove(list.size() - 1);
        }
    }
    
    private int computeSum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
    
    private boolean isPrime(int n) {
        if (n == 0 || n == 1 || n == -1) {
            return false;
        }
        n = n > 0 ? n : -n;
        int sq = (int) Math.sqrt(n);
        for (int i = 2; i <= sq; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getWays(new int[]{3, 7, 12, 19}, 3));
    }
}