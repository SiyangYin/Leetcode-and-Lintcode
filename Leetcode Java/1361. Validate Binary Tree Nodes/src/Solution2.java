public class Solution2 {
    
    class UnionFind {
        private int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            
            return x;
        }
        
        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return false;
            }
            
            parent[x] = y;
            return true;
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
        
        int rootNum = 0;
        for (int i = 0; i < n; i++) {
            if (i == uf.find(i)) {
                rootNum++;
            }
        }
        
        return  rootNum == 1;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] left = {1, -1, 3, -1}, right = {-1, 3, -1, -1};
        Solution2 solution = new Solution2();
        System.out.println(solution.validateBinaryTreeNodes(n, left, right));
    }
}
