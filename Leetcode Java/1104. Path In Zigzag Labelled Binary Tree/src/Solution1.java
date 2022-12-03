import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> pathInZigZagTree(int label) {
        int row = (int) (Math.log(label) / Math.log(2)) + 1;
        int start = (int)Math.pow(2, row - 1);
        int end = (int)Math.pow(2, row) - 1;
        int pos = label;
        if (row % 2 == 0) {
            pos = end - label + start;
        }
        List<Integer> list = new LinkedList<>();
        while (pos > 0) {
            list.add(0, pos % 2);
            pos /= 2;
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int j = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == 0) {
                j *= 2;
            }
            else {
                j = 2 * j + 1;
            }
            if (i % 2 == 0) {
                res.add(j);
            }
            else {
                res.add((int)Math.pow(2, i + 1) - 1 - j + (int)Math.pow(2, i));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().pathInZigZagTree(14));
        System.out.println(new Solution1().pathInZigZagTree(16));
    }
}
