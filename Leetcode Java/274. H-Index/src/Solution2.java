public class Solution2 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];
        for (int citation : citations) {
            count[Math.min(len, citation)]++;
        }
        
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += count[i];
            if (i <= sum) {
                return i;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().hIndex(new int[]{0, 1}));
        System.out.println(new Solution2().hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
