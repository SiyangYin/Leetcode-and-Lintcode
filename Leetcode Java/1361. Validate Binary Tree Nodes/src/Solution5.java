import java.util.HashSet;
import java.util.Set;

public class Solution5 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                parent[leftChild[i]] = i;
            }
            if (rightChild[i] != -1) {
                parent[rightChild[i]] = i;
            }
        }
        find(parent, 0, new boolean[n]);
        for (int i = 1; i < n; i++) {
            find(parent, i, new boolean[n]);
            if (parent[i] != parent[0]) {
                return false;
            }
        }
        if (!dfs(leftChild, rightChild, parent[0], new HashSet<>())) {
            return false;
        }
        return true;
    }

    public int find(int[] parent, int x, boolean[] visited) {
        if (!visited[x]) {
            visited[x] = true;
            if (parent[x] != x) {
                parent[x] = find(parent, parent[x], visited);
            }
        }
        return parent[x];
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
        Solution5 solution = new Solution5();
        System.out.println(solution.validateBinaryTreeNodes(n, left, right));
    }
}
