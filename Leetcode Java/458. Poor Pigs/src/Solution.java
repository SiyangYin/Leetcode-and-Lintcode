public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie + 1;
        int n = buckets - 1;
        int count = 0;
        while (n != 0) {
            n /= k;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().poorPigs(5, 1, 2));
    }
}
