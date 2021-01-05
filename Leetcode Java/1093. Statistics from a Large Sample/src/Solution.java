import java.util.Arrays;

public class Solution {
    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, mode = 0, amount = 0, maxCount = 0;
        double sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += i * count[i];
                amount += count[i];
                
                if (count[i] > maxCount) {
                    maxCount = count[i];
                    mode = i;
                }
            }
        }
        
        double average = (double) sum / amount;
        int l = 0, r = 0;
        if (amount % 2 == 0) {
            l = amount / 2;
            r = l + 1;
        } else {
            l = r = amount / 2 + 1;
        }
        
        boolean odd = amount % 2 != 0;
        amount = 0;
        int posl = 0, posr = 0;
        boolean foundl = false, foundr = false;
        for (int i = 0; i < count.length; i++) {
            amount += count[i];
            if (amount >= r && !foundr) {
                posr = i;
                foundr = true;
            }
            if (amount >= l && !foundl) {
                posl = i;
                foundl = true;
            }
            
            if (foundl && foundr) {
                break;
            }
        }
        
        return new double[]{min, max, average, odd ? posl : (double) (posl + posr) / 2, mode};
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sampleStats(new int[]{0, 1, 3, 4, 0})));
        System.out.println(Arrays.toString(new Solution().sampleStats(new int[]{0, 4, 3, 2, 2})));
    }
}
