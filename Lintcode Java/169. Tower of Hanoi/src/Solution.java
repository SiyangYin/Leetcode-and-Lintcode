import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    public List<String> towerOfHanoi(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        Hanoi(n, 'A', 'C', 'B', list);
        return list;
    }
    
    public void Hanoi(int n, char src, char dest, char mid, List<String> solution) {
        if (n == 1) {
            solution.add("from " + src + " to " + dest);
        } else {
            Hanoi(n - 1, src, mid, dest, solution);
            Hanoi(1, src, dest, mid, solution);
            Hanoi(n - 1, mid, dest, src, solution);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().towerOfHanoi(4));
    }
}
