import java.util.Arrays;

public class Solution {
    /**
     * @param boxes:
     * @return: the number of boxes
     */
    public int maxBoxes(int[][] boxes) {
        // Write your code here.
        for (int[] box : boxes) {
            if (box[0] > box[1]) {
                swap(box);
            }
        }
    
        Arrays.sort(boxes, (b1, b2) -> b1[1] != b2[1] ? Integer.compare(b1[1], b2[1]) : -Integer.compare(b1[0], b2[0]));
        int[] f = new int[boxes.length];
        int idx = -1;
        for (int i = 0; i < boxes.length; i++) {
            if (i == 0 || f[idx] < boxes[i][0]) {
                f[++idx] = boxes[i][0];
            } else {
                int pos = binarySearch(f, idx, boxes[i][0]);
                f[pos] = boxes[i][0];
            }
        }
        
        return idx + 1;
    }
    
    private int binarySearch(int[] f, int idx, int target) {
        int l = 0, r = idx;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (f[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private void swap(int[] box) {
        int tmp = box[0];
        box[0] = box[1];
        box[1] = tmp;
    }
}
