import java.util.Arrays;

public class ConnectingGraph2 {
    
    private int[] parent, size;
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    /*
     * @param n: An integer
     */
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        size = new int[n];
        Arrays.fill(size, 1);
    }
    
    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int pa  = find(a - 1), pb = find(b - 1);
        if (pa != pb) {
            size[pb] += size[pa];
            parent[pa] = pb;
        }
    }
    
    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        return size[find(a - 1)];
    }
    
    public static void main(String[] args) {
        ConnectingGraph2 uf = new ConnectingGraph2(6);
        System.out.println(uf.query(5));
        System.out.println(uf.query(1));
        System.out.println(uf.query(5));
        uf.connect(5, 6);
        System.out.println(uf.query(1));
        uf.connect(1, 4);
        System.out.println(uf.query(3));
        uf.connect(4, 6);
        System.out.println(uf.query(1));
        System.out.println(uf.query(4));
        System.out.println(uf.query(4));
        System.out.println(uf.query(1));
    }
}