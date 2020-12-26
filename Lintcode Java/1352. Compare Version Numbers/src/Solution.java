public class Solution {
    /**
     * @param version1: the first given number
     * @param version2: the second given number
     * @return: the result of comparing
     */
    public int compareVersion(String version1, String version2) {
        // Write your code here
        String[] l1 = version1.split("\\."), l2 = version2.split("\\.");
        for (int i = 0; i < Math.min(l1.length, l2.length); i++) {
            int v1 = Integer.parseInt(l1[i]), v2 = Integer.parseInt(l2[i]);
            if (v1 != v2) {
                return Integer.compare(v1, v2);
            }
        }
        
        if (l1.length == l2.length) {
            return 0;
        } else {
            return l1.length > l2.length ? 1 : -1;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1", "01"));
    }
}
