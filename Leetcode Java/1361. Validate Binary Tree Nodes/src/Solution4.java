import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        for (int i = n - 1; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            if (!dfs(leftChild, rightChild, i, set)) {
                return false;
            }
            if (set.size() == n) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int[] leftChild, int[] rightChild, int i, Set<Integer> set) {
        if (i == -1) {
            return true;
        }
        set.add(i);
        if (set.contains(leftChild[i]) || set.contains(rightChild[i])) {
            return false;
        }
        return dfs(leftChild, rightChild, leftChild[i], set) && dfs(leftChild, rightChild, rightChild[i], set);
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] left = {1, -1, 3, -1}, right = {-1, 3, -1, -1};
        Solution4 solution = new Solution4();
        System.out.println(solution.validateBinaryTreeNodes(n, left, right));
    }
}
