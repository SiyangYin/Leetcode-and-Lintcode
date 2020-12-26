import java.util.Arrays;

public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        // Write your code here
        Arrays.sort(array, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : -Integer.compare(o1[1], o2[1]));
        return array;
    }
}
