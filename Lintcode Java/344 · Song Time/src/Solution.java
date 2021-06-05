public class Solution {
    /**
     * @param song: an array represent song'time
     * @param M:    an integer represent sont time limit
     * @return: return the longest time for song
     */
    public int LongestSongTime(int[] song, int M) {
        // write your code here
        int max = 0, idx = 0;
        for (int i = 0; i < song.length; i++) {
            if (song[i] > max) {
                max = song[i];
                idx = i;
            }
        }
        
        int[] f = new int[M];
        for (int i = 0; i < song.length; i++) {
            if (i == idx) {
                continue;
            }
            
            for (int j = M - 1; j >= song[i]; j--) {
                f[j] = Math.max(f[j], f[j - song[i]] + song[i]);
            }
        }
        
        return f[M - 1] + max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().LongestSongTime(new int[]{2, 3, 6, 7, 9}, 15));
    }
}
