import java.util.Random;

public class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int x = rand7(), y = rand7();
            int n = 7 * (x - 1) + y;
            if (n <= 40) {
                return (n - 1) / 4 + 1;
            }
        }
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Solution().rand10());
        }
    }
}

abstract class SolBase {
    int rand7() {
        return new Random().nextInt(7) + 1;
    }
}