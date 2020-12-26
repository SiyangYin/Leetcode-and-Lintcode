public class BloomFilter<T> {
    
    private int bitSize = 20;
    
    // 二进制向量
    private long[] bits = new long[1];
    
    private int hashSize;
    
    /**
     * @param n 数据规模
     * @param p 误判率
     */
    public BloomFilter(int n, double p) {
        if (n <= 0 || p <= 0 || p >= 1) {
            throw new IllegalArgumentException("wrong n or p");
        }
        double ln2 = Math.log(2);
        bitSize = (int) (-(n * Math.log(p)) / (ln2 * ln2));
        hashSize = (int) (bitSize * ln2 / n);
        
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE + 1];
    }
    
    public void put(T value) {
    
    }
    
    public boolean contains(T value) {
        return false;
    }
}
