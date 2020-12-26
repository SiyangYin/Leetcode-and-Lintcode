public class ConnectingGraph {

    class UnionFind {
        private int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

        }

        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }

            return parent[p];
        }

        public void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }

        }
    }

    UnionFind uf;

    /*
     * @param n: An integer
     */
    public ConnectingGraph(int n) {
        // do intialization if necessary
        uf = new UnionFind(n);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        uf.union(a - 1, b - 1);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return uf.find(a - 1) == uf.find(b - 1);
    }
}