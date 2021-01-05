import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSystem {
    
    class Account {
        private List<Integer> totalAmount;
        private List<Long> timeStamps;
        private int len;
        
        public Account() {
            totalAmount = new ArrayList<>();
            timeStamps = new ArrayList<>();
        }
        
        public void deposite(int amount, long timeStamp) {
            if (totalAmount.isEmpty()) {
                totalAmount.add(amount);
            } else {
                totalAmount.add(totalAmount.get(len - 1) + amount);
            }
            
            timeStamps.add(timeStamp);
            len++;
        }
        
        public boolean withdraw(int amount, long timeStamp) {
            if (totalAmount.isEmpty() || totalAmount.get(len - 1) < amount) {
                return false;
            }
            
            totalAmount.add(totalAmount.get(len - 1) - amount);
            timeStamps.add(timeStamp);
            len++;
            return true;
        }
        
        public int[] check(long start, long end) {
            int[] res = new int[2];
            int idx1 = binarySearch(start), idx2 = binarySearch(end);
            res[0] = idx1 != -1 ? totalAmount.get(idx1) : 0;
            res[1] = idx2 != -1 ? totalAmount.get(idx2) : 0;
            return res;
        }
        
        private int binarySearch(long time) {
            int l = 0, r = len - 1;
            while (l < r) {
                int m = l + (r - l + 1 >> 1);
                if (timeStamps.get(m) <= time) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            
            return timeStamps.get(l) <= time ? l : -1;
        }
        
    }
    
    private Map<Integer, Account> map;
    
    public BankSystem() {
        // Write your code here
        map = new HashMap<>();
    }
    
    /**
     * @param id:        user account id
     * @param amount:    the number of bank deposits
     * @param timestamp: the data of bank transaction
     * @return: nothing
     */
    public void deposite(int id, int amount, long timestamp) {
        // Write your code here
        map.putIfAbsent(id, new Account());
        map.get(id).deposite(amount, timestamp);
    }
    
    /**
     * @param id:        user account id
     * @param amount     : the number of bank withdraw
     * @param timestamp: the data of bank transaction
     * @return: if user account can not withdraw the number of amount,return false. else return true
     */
    public boolean withdraw(int id, int amount, long timestamp) {
        // Write your code here
        if (!map.containsKey(id)) {
            return false;
        }
        
        return map.get(id).withdraw(amount, timestamp);
    }
    
    /**
     * @param id:        user account id
     * @param startTime: start time
     * @param endTime:   end time
     * @return: need return two numbers,the first one is start time account balance,the second is end time account balance
     */
    public int[] check(int id, long startTime, long endTime) {
        // Write your code here
        if (!map.containsKey(id)) {
            return new int[0];
        }
        
        return map.get(id).check(startTime, endTime);
    }
}