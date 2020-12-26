public class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }
        
        boolean[] b = new boolean[N];
        int[] count = new int[N];
        for (int[] pair : trust) {
            b[pair[0] - 1] = true;
            count[pair[1] - 1]++;
        }
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] == N - 1 && !b[i]) {
                return i + 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int N = 3;
        int[][] tr = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(new Solution().findJudge(N, tr));
    }
}
