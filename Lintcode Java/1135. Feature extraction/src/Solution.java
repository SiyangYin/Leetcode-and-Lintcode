import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param frames: A series of frames
     * @return: Find the longest feature movement
     */
    public int FeatureExtraction(int[][] frames) {
        // write your code here
        Map<String, Integer> preFea = new HashMap<>(), curFea = new HashMap<>();
        int res = 0;
        for (int i = 0; i < frames.length; i++) {
            for (int j = 0; j < frames[i][0]; j++) {
                String fea = frames[i][2 * j + 1] + " " + frames[i][2 * j + 2];
                int preCount = preFea.getOrDefault(fea, 0);
                curFea.put(fea, preCount + 1);
                res = Math.max(res, preCount + 1);
            }
            
            preFea = curFea;
            curFea = new HashMap<>();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] fr = {
                {2, 1, 1, 2, 2},
                {2, 1, 1, 1, 4},
                {2, 1, 1, 2, 2},
                {2, 2, 2, 1, 4},
                {0},
                {0},
                {1, 1, 1},
                {1, 1, 1}};
        System.out.println(new Solution().FeatureExtraction(fr));
    }
}
