import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // map the value to the node
    // 存储key和链表节点的键值对
    private Map<Integer, Node> map;
    // 一个存cache里已经有多少元素了，另一个存容量限制
    private int size, capacity;
    // 为了删除和添加方便，开一个虚拟头结点，并且开一个last节点存储链表的最后一个节点
    private Node dummy, last;
    
    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        map = new HashMap<>();
        dummy = new Node(0, 0);
        this.capacity = capacity;
    }
    
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        // 如果不存在key，直接返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        
        // 通过map找到对应的节点，接下来将其挪到链表结尾
        Node node = map.get(key);
        // 如果node就是链表结尾，那就不用挪了，否则就开始挪
        if (node != last) {
            // 将node的前驱和后继互相之间连起来
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 将node挪到last的后面
            node.prev = last;
            last.next = node;
            // 更新last
            last = node;
            // 将链表末尾置为null
            last.next = null;
        }
        
        // 返回对应的value
        return node.val;
    }
    
    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        // 分两种情况考虑，哈希表里存在key和不存在key
        if (!map.containsKey(key)) {
            // 如果不存在key，并且当前链表为空，则new出新节点加在dummy后面，同时更新last
            if (size == 0) {
                dummy.next = new Node(key, value);
                dummy.next.prev = dummy;
                last = dummy.next;
            } else {
                // 如果链表里已经有节点了，就在last后面new出新节点，并更新last
                last.next = new Node(key, value);
                last.next.prev = last;
                last = last.next;
                
            }
            // 在哈希表里加进去新的键值对
            map.put(key, last);
            // 记录cache的size加1
            size++;
            
            // 判断一下size是否大于了容量限制，如果是，还需要删除链表头节点
            if (size > capacity) {
                // 取出头结点，并将其在链表中删除
                Node node = dummy.next;
                dummy.next = dummy.next.next;
                dummy.next.prev = dummy;
                
                // 通过node的key来删除map里对应的key。这就是为什么Node类里要存key
                map.remove(node.key);
                // 记录cache的size减1
                size--;
            }
        } else {
            // 如果已经存在了key，就将对应的node取出
            Node node = map.get(key);
            // 如果node不是链表尾，则按照get里类似的逻辑将其挪到末尾
            if (node != last) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = last;
                last.next = node;
                last = node;
                last.next = null;
            }
            
            // 更新node对应的value
            node.val = value;
        }
    }
}
