public class Solution3 {
    
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
        int[] count = new int[n];
        
        UnionFind uf = new UnionFind(n);
        
        int len = leftChild.length;
        for (int i = 0; i < len; i++) {
            int left = leftChild[i], right = rightChild[i];
            if ((left != -1 && !uf.union(left, i)) || (right != -1 && !uf.union(right, i))) {
                return false;
            }
            if (left != -1) {
                count[left]++;
            }
            if (right != -1) {
                count[right]++;
            }
        }
        
        if (uf.getGroup() != 1){
            return false;
        }
    
        int rootNum = 0;
        for (int c : count) {
            if (c == 0) {
                rootNum++;
                continue;
            }
            
            if (c != 1) {
                return false;
            }
        }
        
        if (rootNum != 1) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] left = {1, -1, 3, -1}, right = {-1, 3, -1, -1};
        System.out.println(new Solution3().validateBinaryTreeNodes(n, left, right));
    }
}
