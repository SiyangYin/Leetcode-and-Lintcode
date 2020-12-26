import java.util.BitSet;

public class PhoneDirectory {
    
    private BitSet bitSet;
    private int maxNum;
    
    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        bitSet = new BitSet(maxNumbers);
        maxNum = maxNumbers;
    }
    
    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        int idx = bitSet.nextClearBit(0);
        bitSet.set(idx);
        
        if (idx < maxNum) {
            return idx;
        } else {
            return -1;
        }
    }
    
    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !bitSet.get(number);
    }
    
    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        bitSet.clear(number);
    }
}
