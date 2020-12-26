import java.lang.annotation.Retention;
import java.util.ArrayList;

public class Solution {
    /**
     * @param array a BitInteger list
     * @return an integer
     */
    public int findMissing(ArrayList<BitInteger> array) {
        // Write your code here
        int res = 0;
    
        for (BitInteger bitInteger : array) {
            for (int j = 0; j < 32; j++) {
                res ^= bitInteger.fetch(j) << j;
            }
        }
    
        for (int i = 0; i < array.size(); i++) {
            res ^= i + 1;
        }
        
        return res;
    }
}

class BitInteger {
    public static int INTEGER_SIZE = 31;
    public int fetch(int j) {
        // .... // return 0 or 1, fetch the jth bit of this number
        return 0;
    }
}