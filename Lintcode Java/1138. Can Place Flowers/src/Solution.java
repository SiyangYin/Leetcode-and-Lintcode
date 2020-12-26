public class Solution {
    /**
     * @param flowerbed: an array
     * @param n: an Integer
     * @return: if n new flowers can be planted in it without violating the no-adjacent-flowers rule
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Write your code here
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            
            if (check(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        
        return n <= 0;
    }
    
    private boolean check(int[] A, int pos) {
        if (pos - 1 >= 0 && A[pos - 1] == 1) {
            return false;
        }
        if (pos + 1 < A.length && A[pos + 1] == 1) {
            return false;
        }
        
        return true;
    }
}
