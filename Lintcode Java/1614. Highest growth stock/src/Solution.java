import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param Stock: Stock information
     * @return: return id
     */
    public String highestGrowth(List<List<String>> Stock) {
        // Write your code here
        double maxGrowth = 0.0;
        String maxStock = null;
    
        for (int i = 0; i < Stock.size(); i++) {
            double s1 = Double.parseDouble(Stock.get(i).get(2));
            double s0 = Double.parseDouble(Stock.get(i).get(1));
            double growth = (s1 - s0) / s0;
            if (growth > maxGrowth) {
                maxGrowth = growth;
                maxStock = Stock.get(i).get(0);
            }
        }
        
        return maxStock;
    }
    
}
