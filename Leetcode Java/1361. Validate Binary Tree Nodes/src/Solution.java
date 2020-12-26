public class Solution {
    
    class UnionFind {
        int[] parent;
        int group;
    
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            group = n;
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return false;
            }
            
            parent[px] = py;
            group--;
            return true;
        }
    
        public int getGroup() {
            return group;
        }
    }
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        
        
        int len = leftChild.length;
        for (int i = 0; i < len; i++) {
            int left = leftChild[i], right = rightChild[i];
            if ((left != -1 && !uf.union(left, i)) || (right != -1 && !uf.union(right, i))) {
                return false;
            }
        }
        
        return  uf.getGroup() == 1;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] left = {1, -1, 3, -1}, right = {-1, 3, -1, -1};
        Solution solution = new Solution();
        System.out.println(solution.validateBinaryTreeNodes(n, left, right));
    }
}
