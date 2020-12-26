import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param op: the type of information
     * @param name: the name of user
     * @param w: the money need to save or take
     * @return: output the remaining money of the user.if the operation is illegal,output -1
     */
    public int[] getAns(int[] op, String[] name, int[] w) {
        // Write your code here
        Map<String, Integer> account = new HashMap<>();
    
        int[] res = new int[op.length];
        for (int i = 0; i < op.length; i++) {
            if (op[i] == 0) {
                account.put(name[i], account.getOrDefault(name[i], 0) + w[i]);
                res[i] = account.get(name[i]);
            } else {
                int money = account.getOrDefault(name[i], 0);
                if (money < w[i]) {
                    res[i] = -1;
                } else {
                    account.put(name[i], money - w[i]);
                    res[i] = money - w[i];
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] op = {1, 0, 0, 0, 1, 1, 1};
        String[] name = {"zzl", "gyc", "zzl", "zzl", "zzl", "zzl", "gyc"};
        int[] w = {20, 30, 40, 50, 30, 70, 30};
        System.out.println(Arrays.toString(new Solution().getAns(op, name, w)));
    }
}
