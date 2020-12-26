public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int left = 0, right = A.length - 1;
        if (A[left] == target || A[right] == target) {
            return true;
        }
        while (A[left] == A[0] && left < right) {
            left++;
        }
        while (A[right] == A[A.length - 1] && right > left) {
            right--;
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] >= A[left]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return A[left] == target || A[right] == target;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{9, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9}, 8));
    }
    
}