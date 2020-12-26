public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (SVNRepo.isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}

class SVNRepo {
    public static boolean isBadVersion(int k) {
        return false;
    }
}