public class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        
        double sum = 0;
        for (int s : salary) {
            if (min < s && s < max) {
                sum += s;
            }
        }
        
        return sum / (salary.length - 2);
    }
}
