import java.util.HashMap;
import java.util.Map;

public class LFUCache2 {
    
    class ListNode {
        int key, val;
        Block block;
        ListNode prev, next;
        
        public ListNode(int key, int val) {
            // this.key = key;
            this.val = val;
        }
    }
    
    class Block {
        int freq;
        Block prev, next;
        ListNode dummy, tail;
        
        public Block(int freq) {
            this.freq = freq;
            dummy = tail = new ListNode(0, 0);
        }
        
        public void insertFirst(ListNode node) {
            node.next = dummy.next;
            node.prev = dummy;
            node.prev.next = node;
            if (node.next != null) {
                node.next.prev = node;
            }
            
            if (tail == dummy) {
                tail = node;
            }
            
            node.block = this;
        }
        
        public void remove(ListNode node) {
            if (node == tail) {
                tail = tail.prev;
            }
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
    }
    
    private Map<Integer, ListNode> map;
    private Block blockDummy;
    private int capacity, size;
    
    /*
     * @param capacity: An integer
     */
    public LFUCache2(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        map = new HashMap<>();
        blockDummy = new Block(0);
    }
    
    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        // 如果含该key，则更新其value，再get一下，就能将其freq增加1了
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }
        
        // 不含这个key，说明要插入
        // 如果size达到了上限，则先要清理freq最小的block里的tail节点
        if (size == capacity) {
            Block minFreqblock = blockDummy.next;
            if (minFreqblock == null) {
                return;
            }
            
            // 删掉这个block里的链表的tail
            map.remove(minFreqblock.tail.key);
            
            minFreqblock.remove(minFreqblock.tail);
            // 如果该block没有链表节点了，则将该block删除
            if (minFreqblock.tail == minFreqblock.dummy) {
                minFreqblock.prev.next = minFreqblock.next;
                if (minFreqblock.next != null) {
                    minFreqblock.next.prev = minFreqblock.prev;
                }
            }
            
            size--;
        }
        
        // new出链表节点，并存入哈希表
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        
        Block oneFreqBlock = null;
        // 如果没有freq是1的block，则new出来，然后将node加进去
        if (blockDummy.next == null || blockDummy.next.freq != 1) {
            // new出freq是1的block
            oneFreqBlock = new Block(1);
            // 将这个freq是1的block插在blockDummy的后面
            oneFreqBlock.next = blockDummy.next;
            oneFreqBlock.prev = blockDummy;
            oneFreqBlock.prev.next = oneFreqBlock;
            if (oneFreqBlock.next != null) {
                oneFreqBlock.next.prev = oneFreqBlock;
            }
        } else {
            // 走到这里说明存在freq是1的block
            oneFreqBlock = blockDummy.next;
        }
        
        oneFreqBlock.insertFirst(node);
        size++;
    }
    
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        ListNode node = map.get(key);
        // 取出node所在的block
        Block block = node.block;
        // 取出freq并看一下是否存在freq + 1的block
        int freq = block.freq;
        
        Block plus1Block = null;
        // 如果不存在freq + 1的block，则new出来
        if (block.next == null || block.next.freq != freq + 1) {
            plus1Block = new Block(freq + 1);
            plus1Block.next = block.next;
            plus1Block.prev = block;
            plus1Block.prev.next = plus1Block;
            
            if (plus1Block.next != null) {
                plus1Block.next.prev = plus1Block;
            }
        } else {
            plus1Block = block.next;
        }
        
        // 接着将node从其所在的block里分离出来
        // 如果这个node是这个block里唯一的节点，那就将这个block删掉
        if (block.tail.prev == block.dummy) {
            block.prev.next = block.next;
            block.next.prev = block.prev;
        } else {
            // 否则的话就将该node从这个block里删掉
            block.remove(node);
        }
        
        // 删完之后，要将node加入plus1Block里
        plus1Block.insertFirst(node);
        node.block = plus1Block;
        return node.val;
    }
    
    public static void main(String[] args) {
        LFUCache2 cache2 = new LFUCache2(3);
        cache2.set(2, 2);
        cache2.set(1, 1);
        System.out.println(cache2.get(2));
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(2));
        cache2.set(3, 3);
        cache2.set(4, 4);
        System.out.println(cache2.get(3));
        System.out.println(cache2.get(2));
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(4));
    }
}