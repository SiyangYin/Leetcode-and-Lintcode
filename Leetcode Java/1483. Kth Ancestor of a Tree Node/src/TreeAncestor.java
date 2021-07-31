public class TreeAncestor {
    
    private int[][] p;
    private int log;
    
    public TreeAncestor(int n, int[] parent) {
        log = (int) (Math.log(n - 1) / Math.log(2)) + 1;
        p = new int[n][log];
        for (int i = 0; i < parent.length; i++) {
            p[i][0] = parent[i];
        }
        for (int i = 1; i < log; i++) {
            for (int j = 0; j < n; j++) {
                if (p[j][i - 1] != -1) {
                    p[j][i] = p[p[j][i - 1]][i - 1];
                } else {
                    p[j][i] = -1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int pow = 0;
        while (k > 0) {
            if (pow >= log || node == -1) {
                return -1;
            }
            
            if ((k & 1) == 1) {
                node = p[node][pow];
            }
            
            k >>= 1;
            pow++;
        }
        
        return node;
    }
    
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(5, new int[]{-1, 0, 0, 0, 3});
        // TreeAncestor treeAncestor = new TreeAncestor(5, new int[]{-1, 0, 1, 2, 3});
        System.out.println(treeAncestor);
    
        System.out.println(treeAncestor.getKthAncestor(1, 5));
        System.out.println(treeAncestor.getKthAncestor(3, 2));
        System.out.println(treeAncestor.getKthAncestor(0, 1));
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(3, 5));
    }
}
