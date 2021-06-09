public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int s1 = 0, s2 = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            s1 += distance[i];
        }
    
        for (int i = destination; i != start ; i = (i + 1) % distance.length) {
            s2 += distance[i];
        }
        
        return Math.min(s1, s2);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
    }
}
