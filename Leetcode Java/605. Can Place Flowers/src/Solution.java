public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            
            boolean canPlace = true;
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                canPlace = false;
            }
            if (i > 0 && flowerbed[i - 1] == 1) {
                canPlace = false;
            }
            
            if (canPlace) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
