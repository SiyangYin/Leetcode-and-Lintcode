public class Solution {
    /**
     * @param musics: the musics
     * @return: calc the number of pair of music
     */
    public long musicPairs(int[] musics) {
        // write your code here
        long[] count = new long[61];
        for (int music : musics) {
            count[music]++;
        }
        
        long res = 0;
        for (int i = 1; i < 30; i++) {
            res += count[i] * count[60 - i];
        }
        for (int i = 30; i <= 60; i += 30) {
            if (count[i] >= 2) {
                res += count[i] * (count[i] - 1) / 2;
            }
        }
        
        return res;
    }
}
