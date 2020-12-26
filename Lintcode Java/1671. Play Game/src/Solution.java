import java.util.Arrays;

public class Solution {
    /**
     * @param A:
     * @return: nothing
     */
    public long playGames(int[] A) {
        // Write your code here
        Arrays.sort(A);
        long games = 0;
        while (A[A.length - 1] > 0) {
            games += A[0] == 0 ? A[1] - A[0] : A[1] - A[0] + 1;
            int m = A[1] - A[0] + 1;
            minusk(A, A[1] - A[0] + 1, 1, A.length - 1);
//            System.out.println(Arrays.toString(A));
            int i = 1;
            while (i < A.length && A[0] > A[i]) {
                i++;
            }
            int tmp = A[0];
            A[0] = A[i - 1];
            A[i - 1] = tmp;
            System.out.println(Arrays.toString(A) + "  " + m);
        }
        return games;
    }
    
    private void minusk(int[] A, int k, int start, int end) {
        for (int i = start; i <= end; i++) {
            A[i] -= k;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().playGames(new int[]{2, 2, 2, 2}));
//        System.out.println(new Solution().playGames(new int[]{84, 53}));
    }
}