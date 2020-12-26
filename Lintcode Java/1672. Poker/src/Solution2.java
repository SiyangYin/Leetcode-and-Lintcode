public class Solution2 {
    private int min;
    public int getAns(int[] cards) {
        int[] newCards = new int[9];
        for (int card : cards)
            newCards[card - 1]++;
        min = newCards.length;
        dfs(newCards, 0);
        return min;
    }
    
    private void dfs(int[] cards, int sum) {
        boolean flag = cards[4] == 0;
        int index1 = 0, index2 = 8;
        for (int i = 3; i >= 0; i--)
            if (cards[i] == 0) {
                index1 = i;
                break;
            }
        for (int i = 5; i < 9; i++)
            if (cards[i] == 0) {
                index2 = i;
                break;
            }
        if (flag || !flag && (index2 - index1) <= 5) {
            int res = 0;
            for (int i = 0; i < cards.length; i++)
                if (cards[i] != 0)
                    res++;
            min = Math.min(min, res + sum);
            return;
        }
        A:
        for (int i = 0; i < 5; i++) {
            int j = i, count = 0;
            for (; j < cards.length; j++) {
                if (cards[j] == 0 && j - i < 5)
                    continue A;
                if (cards[j] == 0) {
                    count = j - i;
                } else if (j == cards.length - 1)
                    count = j - i + 1;
            }
            while (count != 4) {
                for (int k = i; k < i + count; k++)
                    cards[k]--;
                dfs(cards, 1 + sum);
                for (int k = i; k < i + count; k++)
                    cards[k]++;
                count--;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().getAns(new int[]{2, 2, 2, 3, 4, 5, 7, 1}));
    }
}
