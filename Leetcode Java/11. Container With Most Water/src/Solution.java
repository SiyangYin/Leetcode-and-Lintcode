public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxVolume = 0;
        while (i < j) {
            int curVolume = Math.min(height[i], height[j]) * (j - i);
            if (curVolume > maxVolume) {
                maxVolume = curVolume;
            }
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++; j--;
            }
        }
        return maxVolume;
    }
}
