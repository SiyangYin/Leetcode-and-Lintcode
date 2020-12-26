import java.util.*;

public class Solution {
    
    class Transaction {
        String name, city;
        int time, amount;
        
        public Transaction(String trans) {
            String[] split = trans.split(",");
            this.name = split[0];
            this.time = Integer.parseInt(split[1]);
            this.amount = Integer.parseInt(split[2]);
            this.city = split[3];
        }
        
        @Override
        public String toString() {
            String[] ss = {name, String.valueOf(time), String.valueOf(amount), city};
            return String.join(",", ss);
        }
    }
    
    
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        
        Map<String, List<Transaction>> map = new HashMap<>();
        for (String transaction : transactions) {
            Transaction tran = new Transaction(transaction);
            
            map.putIfAbsent(tran.name, new ArrayList<>());
            map.get(tran.name).add(tran);
        }
        
        for (Map.Entry<String, List<Transaction>> entry : map.entrySet()) {
            List<Transaction> transList = entry.getValue();
            
            for (int i = 0; i < transList.size(); i++) {
                Transaction curTrans = transList.get(i);
                if (curTrans.amount > 1000) {
                    res.add(curTrans.toString());
                } else {
                    for (int j = 0; j < transList.size(); j++) {
                        if (j == i) {
                            continue;
                        }
    
                        Transaction another = transList.get(j);
                        if (Math.abs(another.time - curTrans.time) <= 60 && !another.city.equals(curTrans.city)) {
                            res.add(curTrans.toString());
                            break;
                        }
                    }
                }
                
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] trans = {"bob,689,1910,barcelona", "bob,832,1726,barcelona", "bob,820,596,bangkok", "bob,175,221,amsterdam"};
        // String[] trans = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        System.out.println(new Solution().invalidTransactions(trans));
    }
}
